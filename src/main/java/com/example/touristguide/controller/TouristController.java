package com.example.touristguide.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;
import com.example.touristguide.model.TouristAttraction;

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
    public String getAttraction(Model model) {
        model.addAttribute("attractions", service.getTouristRepository());
        return "attractionlist";
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
    public ResponseEntity<String> removeAttraction(@PathVariable String name) {
        service.removeByName(name);
        return new ResponseEntity<>("Removed"+ name, HttpStatus.OK);
    }

}
