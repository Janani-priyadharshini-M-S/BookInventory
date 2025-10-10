package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Inventory;
import com.example.bookInventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    //1
    @PostMapping("/post")
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory saved = inventoryService.save(inventory);
        return ResponseEntity.ok(saved);
    }
    
    //2
    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long inventoryId) {
        Inventory inventory = inventoryService.getById(inventoryId);
        return ResponseEntity.ok(inventory);
    }

    //3
    @PutMapping("/update/purchased/{inventoryId}")
    public ResponseEntity<Inventory> updatePurchasedStatus(@PathVariable Long inventoryId, @RequestBody Boolean purchased) {
        Inventory updated = inventoryService.updatePurchasedStatus(inventoryId, purchased);
        return ResponseEntity.ok(updated);
    }

    
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        return ResponseEntity.ok(inventoryService.getAll());
    }

    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long inventoryId) {
        inventoryService.deleteById(inventoryId);
        return ResponseEntity.noContent().build();
    }
}

//1 error code 

