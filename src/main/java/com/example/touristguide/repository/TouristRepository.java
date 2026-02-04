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

    public void removeByName(String name){
        touristAttractions.removeIf(attraction ->
                attraction.getName().equalsIgnoreCase(name)
        );
    }


    public void addTouristAttraction() {
        touristAttractions.add(new TouristAttraction("mona lisa", " et maleri"));
        touristAttractions.add(new TouristAttraction("nilen", "en flod"));
        touristAttractions.add(new TouristAttraction("den lille havfrue", " en statue"));
    }

    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }


}


