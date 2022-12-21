package de.capstone.backend.service;

import de.capstone.backend.model.Plant;
import de.capstone.backend.model.User;
import de.capstone.backend.repo.UserRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private final UserRepo userRepo = mock(UserRepo.class);
    private final IdService idService = mock(IdService.class);

    List<Plant> plantList = new ArrayList<>();


    @Test
    void should_Return_User_List () {
        //GIVEN
        User user1 = new User("1", "Justus", "email","password",plantList);
        User user2 = new User("2", "Peter", "email","password",plantList);
        User user3 = new User("3", "Bob","email","password",plantList );
        when(userRepo.findAll()).thenReturn(
                List.of(
                        user1,
                        user2,
                        user3
                )
        );
        UserService userService = new UserService(userRepo, idService);

        //WHEN
        List<User> actual = userService.list();

        //THEN
        assertThat(actual, containsInAnyOrder(
                user1,
                user2,
                user3
        ));
    }

    @Test
    void search_Should_Return_User() {
        //GIVEN
        User user;
        when(userRepo.findAll()).thenReturn(
                List.of(
                        user = new User("1", "Justus", "email","password",plantList),
                        new User("2", "Peter", "email","password",plantList),
                        new User("3", "Bob","email","password",plantList )
                )
        );
        UserService userService = new UserService(userRepo, idService);

        //WHEN
        List<User> actual = userService.search("Just");

        //THEN
        assertThat(actual, containsInAnyOrder(
                user
                //new User("1", "Justus", "email","password",plantList)
        ));
    }

    @Test
    void should_Add_User() {
        //GIVEN
        User userToAdd = new User("4", "Morten","email","password",plantList);
        when(userRepo.save(userToAdd)).thenReturn(userToAdd);
        UserService userService = new UserService(userRepo, idService);

        //WHEN
        User result = userService.addUser(userToAdd);

        //THEN
        assertThat(result, is(userToAdd));
        verify(userRepo).save(userToAdd);
    }

    @Test
    void testFindById() {
        //GIVEN
        User user = new User("2", "Peter","email","password",plantList);
        when(userRepo.findById("2")).thenReturn(Optional.of(user));
        UserService userService = new UserService(userRepo, idService);

        //WHEN
        User result = userService.findById("2");

        //THEN
        assertThat(result, is(user));
    }

    @Test
    void find_By_Missing_Id_Should_Be_Empty() {
        //GIVEN
        when(userRepo.findById("9")).thenReturn(Optional.empty());
        UserService userService = new UserService(userRepo, idService);

        //WHEN
        try {
            userService.findById("2");
            fail();
        } catch (IllegalArgumentException e) {
            //THEN
            assertEquals( "User-Id not found!",e.getMessage());
        }
    }

    @Test
    void should_Delete_by_Id() {
        //GIVEN
        User user = new User("2", "Peter","email","password",plantList);
        when(userRepo.findById("2")).thenReturn(Optional.of(user));
        UserService userService = new UserService(userRepo, idService);

        //WHEN
        userService.delete("2");

        //THEN
        verify(userRepo).delete(user);

    }

    @Test
    void should_Add_With_Random_Id() {
        //GIVEN
        User userToAdd = new User(null, "Morten","email","password",plantList);
        User addedUser = new User("k0Lj4", "Skinny","email","password",plantList);

        when(idService.generateId()).thenReturn("k0lj4");
        when(userRepo.save(addedUser)).thenReturn(addedUser);
        UserService userService = new UserService(userRepo, idService);

        //WHEN
        User result = userService.addUser(userToAdd);

        //THEN
        // assertThat(result, is(userToAdd));  TODO assert why not running w assertThat...
        verify(userRepo).save(userToAdd);
    }
}