package com.example.touristguide.controller;

import com.example.touristguide.repository.TouristRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService service;


    public TouristController(TouristService service) {
        this.service = service;
    }

    // GET LIST of Attractions

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getAttraction() {
        List<TouristAttraction> touristAttractions = service.getTouristRepository();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    // GET by name

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = service.getByName(name);

        if (attraction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(attraction, HttpStatus.OK);
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


    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteAttraction(@PathVariable String name) {
        boolean deleted = service.deleteByName(name);

        if (!deleted) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}

