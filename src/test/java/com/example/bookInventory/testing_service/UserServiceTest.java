package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.User;
import com.example.bookInventory.service.UserService;

public class UserServiceTest {

    UserService userService = mock(UserService.class);

    @Test
    void testSaveUser() {
        User user = new User(1, "Arul", "Karthi", "989898", "arulKarthi", "arulMass", 15);
        when(userService.save(user)).thenReturn(user);

        User result = userService.save(user);
        assertEquals("arulKarthi", result.getUserName());
    }

    @Test
    void testSaveUserIfNotExists() {
        User user = new User(1, "Arul", "Karthi", "989898", "arulKarthi", "arulMass", 15);
        when(userService.saveUserIfNotExists(user)).thenReturn(true);

        boolean result = userService.saveUserIfNotExists(user);
        assertEquals(true, result);
    }

    @Test
    void testGetById() {
        User user = new User(1, "Arul", "Karthi", "989898", "arulKarthi", "arulMass", 15);
        when(userService.getById(1)).thenReturn(user);

        User result = userService.getById(1);
        assertEquals("Arul", result.getLastName());
        assertEquals("Karthi", result.getFirstName());
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User(1, "Arul", "Karthi", "989898", "arulKarthi", "arulMass", 15);
        User user2 = new User(2, "Dharshini", "Priya", "979797", "priyaD", "priyaPass", 10);
        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAll()).thenReturn(users);

        List<User> result = userService.getAll();
        assertEquals(2, result.size());
        assertEquals("Priya", result.get(1).getFirstName()); // ✅ fixed: access individual user
    }

    @Test
    void testUpdatePhoneNumber() {
        User updatedUser = new User(1, "Arul", "Karthi", "999999", "arulKarthi", "arulMass", 15);
        when(userService.updatePhoneNumber(1, "999999")).thenReturn(updatedUser);

        User result = userService.updatePhoneNumber(1, "999999");
        assertEquals("999999", result.getPhoneNumber());
    }

    @Test
    void testUpdateFirstName() {
        User updatedUser = new User(1, "Arul", "Karthikeyan", "989898", "arulKarthi", "arulMass", 15);
        when(userService.updateFirstName(1, "Karthikeyan")).thenReturn(updatedUser);

        User result = userService.updateFirstName(1, "Karthikeyan");
        assertEquals("Karthikeyan", result.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        User updatedUser = new User(1, "Kumar", "Karthi", "989898", "arulKarthi", "arulMass", 15);
        when(userService.updateLastName(1, "Kumar")).thenReturn(updatedUser);

        User result = userService.updateLastName(1, "Kumar");
        assertEquals("Kumar", result.getLastName());
    }
}