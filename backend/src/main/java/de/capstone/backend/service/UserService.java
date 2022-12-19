package de.capstone.backend.service;

import de.capstone.backend.model.User;
import de.capstone.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final IdService idService;

    @Autowired
    public UserService(UserRepo userRepo, IdService idService){
        this.userRepo = userRepo;
        this.idService = idService;
    }
   public List<User> list(){
        return userRepo.findAll();}
    public User findById(String id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new IllegalArgumentException("User-Id not found!");
    }
    public User addUser(User user){
        user.setId(idService.generateId());
        return userRepo.save(user);
    }

    public List<User> search(String s) {
        List<User> searchResults = new ArrayList<>();
        for (User user: list()){
            if (user.getName().contains(s)){
                searchResults.add(user);
            }
        }
        return searchResults;
    }
    public void delete(String id){
        User user= findById(id);
        userRepo.delete(user);
    }

}
