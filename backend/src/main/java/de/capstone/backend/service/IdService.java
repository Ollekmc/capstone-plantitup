package de.capstone.backend.service;

import java.util.UUID;

public class IdService {

    public String generateId() {
        return UUID.randomUUID().toString();

}
}

