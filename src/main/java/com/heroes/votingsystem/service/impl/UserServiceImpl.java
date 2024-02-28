package com.heroes.votingsystem.service.impl;

import com.heroes.votingsystem.model.User;
import com.heroes.votingsystem.repository.UserRepository;
import com.heroes.votingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User newUserDetails) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(newUserDetails.getUsername());
            existingUser.setEmail(newUserDetails.getEmail());
            // Diğer alanları da güncelleme
            return userRepository.save(existingUser);
        }
        return null;
    }
}
