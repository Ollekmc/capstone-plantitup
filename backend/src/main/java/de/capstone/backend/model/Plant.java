package de.capstone.backend.model;

public class Plant {
    String id;
    String name;
    Species species;

    public Plant(String id, String name, Species species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
} //TODO: Add individual traits
