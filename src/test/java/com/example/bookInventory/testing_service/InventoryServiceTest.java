package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Inventory;
import com.example.bookInventory.service.InventoryService;

public class InventoryServiceTest {

    InventoryService inventoryService = mock(InventoryService.class);

    @Test
    void testGetInventoryById() {
        Inventory inventory = new Inventory(1L, "123456", 10, true, null);
        when(inventoryService.getById(1L)).thenReturn(inventory);

        Inventory result = inventoryService.getById(1L);
        assertEquals("123456", result.getIsbn());
        assertEquals(10, result.getRanks());
        assertEquals(true, result.getPurchased());
    }

    @Test
    void testAddInventory() {
        Inventory inventory = new Inventory(1L, "123456", 10, true, null);
        when(inventoryService.save(inventory)).thenReturn(inventory);

        Inventory result = inventoryService.save(inventory);
        assertEquals(10, result.getRanks());
        assertEquals(true, result.getPurchased());
    }

    @Test
    void testUpdatePurchasedStatus() {
        Inventory updatedInventory = new Inventory(1L, "123456", 10, false, null);
        when(inventoryService.updatePurchasedStatus(1L, false)).thenReturn(updatedInventory);

        Inventory result = inventoryService.updatePurchasedStatus(1L, false);
        assertEquals(false, result.getPurchased());
    }
}