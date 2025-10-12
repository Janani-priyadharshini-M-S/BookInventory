package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Publisher;
import com.example.bookInventory.service.PublisherService;

public class PublisherServiceTest {

    PublisherService publisherService = mock(PublisherService.class);

    @Test
    void testSavePublisher() {
        Publisher publisher = new Publisher(101, "Deepak", "Salem", "TN");
        when(publisherService.savePublisher(publisher)).thenReturn(true);

        boolean result = publisherService.savePublisher(publisher);
        assertEquals(true, result);
    }

    @Test
    void testGetById() {
        Publisher publisher = new Publisher(101, "Deepak", "Salem", "TN");
        when(publisherService.getById(101L)).thenReturn(publisher);

        Publisher result = publisherService.getById(101L);
        assertEquals("Deepak", result.getName());
        assertEquals("Salem", result.getCity());
        assertEquals("TN", result.getStateCode());
    }

    @Test
    void testGetAll() {
        Publisher p1 = new Publisher(101, "Deepak", "Salem", "TN");
        Publisher p2 = new Publisher(102, "Janani", "Chennai", "TN");
        List<Publisher> publishers = Arrays.asList(p1, p2);

        when(publisherService.getAll()).thenReturn(publishers);

        List<Publisher> result = publisherService.getAll();
        assertEquals(2, result.size());
        assertEquals("Janani", result.get(1).getName());
    }

    @Test
    void testGetByName() {
        Publisher p1 = new Publisher(101, "Deepak", "Salem", "TN");
        when(publisherService.getByName("Deepak")).thenReturn(Arrays.asList(p1));

        List<Publisher> result = publisherService.getByName("Deepak");
        assertEquals(1, result.size());
        assertEquals("Deepak", result.get(0).getName());
    }

    @Test
    void testGetByCity() {
        Publisher p1 = new Publisher(101, "Deepak", "Salem", "TN");
        when(publisherService.getByCity("Salem")).thenReturn(Arrays.asList(p1));

        List<Publisher> result = publisherService.getByCity("Salem");
        assertEquals("Salem", result.get(0).getCity());
    }

    @Test
    void testGetByState() {
        Publisher p1 = new Publisher(101, "Deepak", "Salem", "TN");
        Publisher p2 = new Publisher(102, "Janani", "Chennai", "TN");
        when(publisherService.getByState("TN")).thenReturn(Arrays.asList(p1, p2));

        List<Publisher> result = publisherService.getByState("TN");
        assertEquals(2, result.size());
    }

    @Test
    void testUpdateName() {
        Publisher updated = new Publisher(101, "Janani", "Salem", "TN");
        when(publisherService.updateName(101L, "Janani")).thenReturn(updated);

        Publisher result = publisherService.updateName(101L, "Janani");
        assertEquals("Janani", result.getName());
    }

    @Test
    void testUpdateCity() {
        Publisher updated = new Publisher(101, "Deepak", "Chennai", "TN");
        when(publisherService.updateCity(101L, "Chennai")).thenReturn(updated);

        Publisher result = publisherService.updateCity(101L, "Chennai");
        assertEquals("Chennai", result.getCity());
    }

    @Test
    void testUpdateState() {
        Publisher updated = new Publisher(101, "Deepak", "Salem", "KA");
        when(publisherService.updateState(101L, "KA")).thenReturn(updated);

        Publisher result = publisherService.updateState(101L, "KA");
        assertEquals("KA", result.getStateCode());
    }
}