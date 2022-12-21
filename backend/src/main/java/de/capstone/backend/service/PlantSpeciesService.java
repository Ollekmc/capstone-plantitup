package de.capstone.backend.service;

import de.capstone.backend.model.Species;
import java.util.Collections;
import java.util.List;

public class PlantSpeciesService {
    public List<Species> search(String s) {

        return Collections.emptyList((search(s));
    }

    public List<Species> list() {
        return Collections.emptyList();
    }

    public Species findById(String id) {
        Species species = new Species();
        id = species.getId();
        return species;
    }

    public Species addSpecies(Species species) {
        return  species;
    }

    public void delete(String id) {
        //create method in next commit
    }
}
