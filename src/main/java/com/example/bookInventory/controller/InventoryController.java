
package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Inventory;
import com.example.bookInventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addInventory(@RequestBody Inventory inventory) {
        boolean isAdded = inventoryService.saveInventoryIfNotExists(inventory); // Update service method
        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("code", "POSTSUCCESS");
            response.put("message", "Inventory added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "Inventory already exists");
            return ResponseEntity.status(409).body(response);
        }
    }
    
    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long inventoryId) {
        Inventory inventory = inventoryService.getById(inventoryId);
        return ResponseEntity.ok(inventory);
    }

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
