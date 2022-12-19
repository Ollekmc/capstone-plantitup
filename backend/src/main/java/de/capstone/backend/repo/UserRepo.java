package de.capstone.backend.repo;

import de.capstone.backend.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepo extends MongoRepository<User, String>{
}
