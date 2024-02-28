package com.heroes.votingsystem.service;

import com.heroes.votingsystem.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByUsername(String username);
    void deleteUser(Long id);


    User updateUser(Long id, User newUserDetails);
}
