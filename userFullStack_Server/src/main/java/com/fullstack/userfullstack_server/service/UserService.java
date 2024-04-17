package com.fullstack.userfullstack_server.service;

import com.fullstack.userfullstack_server.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public List<User> getAllActiveUsers() {

//    }

//    public String addNewUser(@RequestBody User user) {
//        long lastUserId = getLastUserId();
//        long newUserId = lastUserId + 1;
//        user.setUserId(newUserId);
//        userRepository.save(user);
//        return "New user " + user.getName() + " has been added!";
//    }
//
//    public String addMultipleUsers(@RequestBody List<User> users) {
//        userRepository.saveAll(users);
//        ArrayList<String> addedUsers = new ArrayList<>();
//        for (User usersAdded : users) {
//            addedUsers.add("User " + usersAdded.getName() + " has been added!");
//        }
//
//        return addedUsers.toString();
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserByID(@PathVariable Long user_id) {
//        return userRepository.findById(user_id)
//                .orElseThrow(() -> new UserNotFoundException(user_id));
//    }
//
//    public long getLastUserId() {
//        User lastUser = userRepository.findFirstByOrderByUserIdDesc();
//        return lastUser.getUserId();
//    }
//
//    public User updateUser(@RequestBody User updatedUser, @PathVariable Long user_id) {
//        return userRepository.findById(user_id)
//                .map(user -> {
//                    //these are checks to make sure that, if the request body has missing fields, to keep those fields with the same values
//                    if (updatedUser.getName() == null) {
//                        updatedUser.setName(user.getName());
//                    }
//                    if (updatedUser.getUserName() == null) {
//                        updatedUser.setUserName(user.getUserName());
//                    }
//                    if (updatedUser.getEmail() == null) {
//                        updatedUser.setEmail(user.getEmail());
//                    }
//
//                    //finally updating the user with the new values
//                    user.setUserName(updatedUser.getUserName());
//                    user.setName(updatedUser.getName());
//                    user.setEmail(updatedUser.getEmail());
//                    //user_id is purposely left out, as that field should be immutable
//
//
//                    return userRepository.save(user);
//                }).orElseThrow(() -> new UserNotFoundException(user_id));
//    }
//
//    public String deleteUser(@PathVariable Long user_id) {
//        if(!userRepository.existsById(user_id)) {
//            throw new UserNotFoundException(user_id);
//        }
//        User userToDelete = userRepository.findById(user_id).get();
//        userRepository.delete(userToDelete);
//        return "User " + userToDelete.getName() + " has been deleted";
//    }
}
