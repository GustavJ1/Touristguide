package com.example.touristguide.service;
import org.springframework.stereotype.Service;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.repository.TouristRepository;


import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getTouristRepository() {
        return touristRepository.getTouristAttractions();
    }

    public void removeByName(String name) {
        touristRepository.removeByName(name);
    }

    public TouristAttraction getByName(String name) {
        return touristRepository.getByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction){
        return touristRepository.add(attraction);
    }




}
