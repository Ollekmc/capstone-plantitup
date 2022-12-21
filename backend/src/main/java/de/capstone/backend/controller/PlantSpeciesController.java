package de.capstone.backend.controller;

import de.capstone.backend.model.Species;
import de.capstone.backend.service.PlantSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/plants")
public class PlantSpeciesController {

    private final PlantSpeciesService plantSpeciesService;

    @Autowired
    public PlantSpeciesController(PlantSpeciesService plantSpeciesService){this.plantSpeciesService = plantSpeciesService;}

    @GetMapping
    public List<Species> listPlantSpecies(@RequestParam Optional<String> search){
        if (search.isPresent()){
            return plantSpeciesService.search(search.get());
        }
        return plantSpeciesService.list();
    }
    @GetMapping("{id}")
    public Species getPlantSpecies(@PathVariable String id){return plantSpeciesService.findById(id);}
    @PostMapping()
    public Species addSpecies(@RequestBody Species species){return plantSpeciesService.addSpecies(species);}
    @DeleteMapping("{id}")
    public void deleteSpecies(@PathVariable String id){plantSpeciesService.delete(id);}


}
