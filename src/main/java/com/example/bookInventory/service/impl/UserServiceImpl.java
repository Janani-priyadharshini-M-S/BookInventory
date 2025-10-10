package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.User;
import com.example.bookInventory.exception.ResourceNotFoundException;
import com.example.bookInventory.repository.UserRepository;
import com.example.bookInventory.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveUserIfNotExists(User user) {
        boolean exists = userRepository.existsByUserName(user.getUserName());
        if (exists) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updatePhoneNumber(Integer userId, String phoneNumber) {
        User user = getById(userId);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

    @Override
    public User updateFirstName(Integer userId, String firstName) {
        User user = getById(userId);
        user.setFirstName(firstName);
        return userRepository.save(user);
    }

    @Override
    public User updateLastName(Integer userId, String lastName) {
        User user = getById(userId);
        user.setLastName(lastName);
        return userRepository.save(user);
    }
}
