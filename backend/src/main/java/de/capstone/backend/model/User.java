package de.capstone.backend.model;

import java.util.List;

public class User {
    String id;
    String name;
    String email;
    String password;
    List<Plant> plantList;

    public User(String id, String name, String email, String password, List<Plant> plantList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.plantList = plantList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }
    //TODO: toString & hash Code+ tests
}
