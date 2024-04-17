package com.fullstack.userfullstack_server.controller;

import com.fullstack.userfullstack_server.database.UserRepository;
import com.fullstack.userfullstack_server.exceptions.UserNotFoundException;
import com.fullstack.userfullstack_server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fullstackUsers")
@CrossOrigin("http://localhost:3000") //connecting the backend to the frontend
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody Users users) {
        long lastUserId = getLastUserId();
        long newUserId = lastUserId + 1;
        users.setUserId(newUserId);
        userRepository.save(users);
        return "New user " + users.getName() + " has been added!";
    }

    @PostMapping("/addMultipleUsers")
    public String addMultipleUsers(@RequestBody List<Users> users) {
        userRepository.saveAll(users);
        ArrayList<String> addedUsers = new ArrayList<>();
        for (Users usersAdded : users) {
            addedUsers.add("User " + usersAdded.getName() + " has been added!");
        }

        return addedUsers.toString();
    }

    @GetMapping("/allUsers")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{user_id}")
    public Users getUserByID(@PathVariable Long user_id) {
        
        return userRepository.findByUserId(user_id)
                .orElseThrow(() -> new UserNotFoundException(user_id));
    }

    @GetMapping("/lastUserId")
    public long getLastUserId() {
        Optional<Users> lastUser = userRepository.findFirstByOrderByUserIdDesc();
        return lastUser.map(Users::getUserId).orElseThrow();
    }

    @PatchMapping("/users/edit/{user_id}")
    public Users updateUser(@RequestBody Users updatedUsers, @PathVariable Long user_id) {
        return userRepository.findByUserId(user_id)
                .map(users -> {
                    //these are checks to make sure that, if the request body has missing fields, to keep those fields with the same values
                    if (updatedUsers.getName() == null) {
                        updatedUsers.setName(users.getName());
                    }
                    if (updatedUsers.getUserName() == null) {
                        updatedUsers.setUserName(users.getUserName());
                    }
                    if (updatedUsers.getEmail() == null) {
                        updatedUsers.setEmail(users.getEmail());
                    }

                    //finally updating the user with the new values
                    users.setUserName(updatedUsers.getUserName());
                    users.setName(updatedUsers.getName());
                    users.setEmail(updatedUsers.getEmail());
                    //user_id is purposely left out, as that field should be immutable


                    return userRepository.save(users);
                }).orElseThrow(() -> new UserNotFoundException(user_id));
    }

    @DeleteMapping("/deleteUser/{user_id}")
    public String deleteUser(@PathVariable Long user_id) {
        if(!userRepository.existsByUserId(user_id)) {
            throw new UserNotFoundException(user_id);
        }
        Users usersToDelete = userRepository.findByUserId(user_id).get();
        userRepository.delete(usersToDelete);
        return "User " + usersToDelete.getName() + " has been successfully deleted";
    }
}
