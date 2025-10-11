package com.example.bookInventory.controller;

import com.example.bookInventory.entity.BookCondition;
import com.example.bookInventory.service.BookConditionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookcondition")
public class BookConditionController {

    @Autowired
    private BookConditionService bookConditionService;
    
    
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> save(@RequestBody BookCondition bookCondition) {
        Map<String, String> response = new HashMap<>();

        if (bookConditionService.existsByRanks(bookCondition.getRanks())) {
            BookCondition existing = bookConditionService.getByRanks(bookCondition.getRanks());

            response.put("code", "ADDFAILS");
            response.put("message", "Book condition already exists with ranks: " + existing.getRanks()
                    + ", price: " + existing.getPrice()
                    + ", description: " + existing.getDescription());

            return ResponseEntity.status(409).body(response);
        }

        BookCondition saved = bookConditionService.save(bookCondition);

        response.put("code", "POSTSUCCESS");
        response.put("message", "Book Condition added successfully with ranks: " + saved.getRanks()
                + ", price: " + saved.getPrice()
                + ", description: " + saved.getDescription());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{ranks}")
    public ResponseEntity<BookCondition> getByRanks(@PathVariable Integer ranks) {
        return ResponseEntity.ok(bookConditionService.getByRanks(ranks));
    }

    @GetMapping
    public ResponseEntity<List<BookCondition>> getAll() {
        return ResponseEntity.ok(bookConditionService.getAll());
    }

    @PutMapping("/update/price/{ranks}")
    public ResponseEntity<BookCondition> updatePrice(@PathVariable Integer ranks, @RequestBody BigDecimal price) {
        return ResponseEntity.ok(bookConditionService.updatePrice(ranks, price));
    }

    @PutMapping("/update/description/{ranks}")
    public ResponseEntity<BookCondition> updateDescription(@PathVariable Integer ranks, @RequestBody String description) {
        return ResponseEntity.ok(bookConditionService.updateDescription(ranks, description));
    }

    @PutMapping("/update/fullDescription/{ranks}")
    public ResponseEntity<BookCondition> updateFullDescription(@PathVariable Integer ranks, @RequestBody String fullDescription) {
        return ResponseEntity.ok(bookConditionService.updateFullDescription(ranks, fullDescription));
    }
}