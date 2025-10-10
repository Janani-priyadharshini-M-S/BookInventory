package com.example.bookInventory.service;

import com.example.bookInventory.entity.User;
import java.util.List;

public interface UserService {
    boolean saveUserIfNotExists(User user);
    User save(User user);
    User getById(Integer userId);
    List<User> getAll();
    User updatePhoneNumber(Integer userId, String phoneNumber);
    User updateFirstName(Integer userId, String firstName);
    User updateLastName(Integer userId, String lastName);
}