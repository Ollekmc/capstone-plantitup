package de.capstone.backend.service;

import de.capstone.backend.model.Species;
import de.capstone.backend.repo.PlantSpeciesRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlantSpeciesService {

    private final PlantSpeciesRepo plantSpeciesRepo;
    private final IdService idService;

    public PlantSpeciesService(PlantSpeciesRepo plantSpeciesRepo, IdService idService) {
        this.plantSpeciesRepo = plantSpeciesRepo;
        this.idService = idService;
    }

    public List<Species> list() {
        return plantSpeciesRepo.findAll();
    }
    public Species findById(String id) {
        Optional<Species> optionalSpecies = plantSpeciesRepo.findById(id);
        if (optionalSpecies.isPresent()) {
            return optionalSpecies.get();
        }
        throw new IllegalArgumentException("Species-Id not found");
    }
    public Species addSpecies(Species species) {
       species.setId(idService.generateId());
       return  plantSpeciesRepo.save(species);
    }
    public List<Species> search(String s) {
        List<Species> searchResults = new ArrayList<>();
        for (Species species:list()){
            if (species.getName().contains(s)){
            searchResults.add(species);
            }
        }
        return searchResults;
    }
    public void delete(String id) {
        Species species = findById(id);
        plantSpeciesRepo.delete(species);
    }
}
