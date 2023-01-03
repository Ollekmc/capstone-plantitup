package de.capstone.backend.repo;

import de.capstone.backend.model.Species;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantSpeciesRepo extends MongoRepository<Species, String> {
}

