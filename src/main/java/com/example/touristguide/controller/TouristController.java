package com.example.touristguide.controller;

import com.example.touristguide.repository.TouristRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService service;


    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getAttraction() {
        List<TouristAttraction> touristAttractions = service.getTouristRepository();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        service.getTouristRepository().add(attraction);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeAttraction(@RequestBody TouristAttraction attraction) {
        service.removeByName(attraction.getName());
        return new ResponseEntity<>("Removed", HttpStatus.OK);
    }

    @GetMapping("/tivoli")
    public ResponseEntity<TouristAttraction> showTivoli() {

        return new ResponseEntity<>(new TouristAttraction("tivoli", "forlystelsespark"), HttpStatus.OK);
    }


}
