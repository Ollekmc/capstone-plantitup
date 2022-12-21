package de.capstone.backend.model;

public class Species {
    String id;
    String name;
    Scale waterDemand;
    Scale fertilizerDemand;

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

    public Scale getWaterDemand() {
        return waterDemand;
    }

    public void setWaterDemand(Scale waterDemand) {
        this.waterDemand = waterDemand;
    }

    public Scale getFertilizerDemand() {
        return fertilizerDemand;
    }

    public void setFertilizerDemand(Scale fertilizerDemand) {
        this.fertilizerDemand = fertilizerDemand;
    }
}
