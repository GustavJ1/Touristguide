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
        touristAttractions.add(new TouristAttraction("mona lisa", " et maleri"));
        touristAttractions.add(new TouristAttraction("nilen", "en flod"));
        touristAttractions.add(new TouristAttraction("den lille havfrue", " en statue"));
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


