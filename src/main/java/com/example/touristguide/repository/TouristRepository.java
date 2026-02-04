package com.example.touristguide.repository;

import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TouristRepository {
    private final ArrayList<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        addTouristAttraction();
    }

    public void addTouristAttraction() {
        touristAttractions.add(new TouristAttraction("Havnebadet Islands Brygge", "Havnebadet Islands Brygge er et friluftsbad midt i København, der tiltrækker børnefamilier, motionssvømmere og strandløver fra hele byen."));
        touristAttractions.add(new TouristAttraction("Kalvebod Fælled", "Vestamager byder i dag på store åbne vidder hvor sol, lys og fugtig salt jord er livsvigtigt for de dyr og planter, som lever på strandengen."));
        touristAttractions.add(new TouristAttraction("CopenHill", "Københavns futuristiske skibakke på toppen af det nye forbrændingsanlæg på Amager"));
        touristAttractions.add(new TouristAttraction("Amager Strandpark", "Københavns største, moderne strandanlæg med over 1 million årlige gæster. Området omfatter en 4,6 km lang hvid sandstrand og en kunstig ø med lagune"));

    }


    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }
    public TouristAttraction getByName(String name) {
        return touristAttractions.stream().filter(a->a.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }



    public TouristAttraction add(TouristAttraction attraction) {
        touristAttractions.add(attraction);
        return attraction;
    }

// MR har lavet removeByName til Boolean så man får feedback efter den kører, men er ikke helt sikker på at det er korrekt sat op - evt. bare udskift boolean med void og fjern return statement.

    public boolean removeByName(String name) {
        touristAttractions.removeIf(attraction ->
                attraction.getName().equalsIgnoreCase(name)
        );
        return true;
    }

}


