package com.example.bookInventory.controller;

import com.example.bookInventory.entity.User;
import com.example.bookInventory.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    

    @GetMapping
      public ResponseEntity<List<User>> getAllUsers() {
          return ResponseEntity.ok(userService.getAll());
      }


    // 1. Add new user
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody User user) {
        boolean isAdded = userService.saveUserIfNotExists(user);

        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("code", "POSTSUCCESS");
            response.put("message", "User added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "User already exist");
            return ResponseEntity.status(409).body(response);
        }
    }

    // 2. Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getById(userId));
    }

    // 3. Update phone number
    @PutMapping("/update/phonenumber/{userId}")
    public ResponseEntity<User> updatePhoneNumber(@PathVariable Integer userId, @RequestBody String phoneNumber) {
        return ResponseEntity.ok(userService.updatePhoneNumber(userId, phoneNumber));
    }

    // 4. Update first name
    @PutMapping("/update/firstname/{userId}")
    public ResponseEntity<User> updateFirstName(@PathVariable Integer userId, @RequestBody String firstName) {
        return ResponseEntity.ok(userService.updateFirstName(userId, firstName));
    }

    // 5. Update last name
    @PutMapping("/update/lastname/{userId}")
    public ResponseEntity<User> updateLastName(@PathVariable Integer userId, @RequestBody String lastName) {
        return ResponseEntity.ok(userService.updateLastName(userId, lastName));
    }
}

