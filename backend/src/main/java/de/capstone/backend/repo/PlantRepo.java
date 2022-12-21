package de.capstone.backend.repo;

import de.capstone.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepo extends MongoRepository<User, String> {
}

