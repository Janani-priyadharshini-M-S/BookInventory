package com.example.bookInventory.controller;



import com.example.bookInventory.entity.Reviewer;
import com.example.bookInventory.service.ReviewerService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
@RestController
@RequestMapping("/api/reviewer")
public class ReviewerController {
 
    @Autowired
    private ReviewerService reviewerService;
 
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addReviewer(@RequestBody Reviewer reviewer) {
        boolean isAdded = reviewerService.saveReviewerIfNotExists(reviewer); // Update service method
 
        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("code", "POSTSUCCESS");
            response.put("message", "Reviewer added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "Reviewer already exist");
            return ResponseEntity.status(409).body(response);
        }
    }
 
    @GetMapping("/employedby/{reviewerId}")
    public ResponseEntity<Reviewer> getReviewerById(@PathVariable Long reviewerId) {
        return ResponseEntity.ok(reviewerService.getById(reviewerId));
    }
 
    @GetMapping
    public ResponseEntity<List<Reviewer>> getAllReviewers() {
        return ResponseEntity.ok(reviewerService.getAll());
    }
 
    @PutMapping("/update/name/{reviewerId}")
    public ResponseEntity<Reviewer> updateReviewerName(@PathVariable Long reviewerId, @RequestBody String name) {
        return ResponseEntity.ok(reviewerService.updateName(reviewerId, name));
    }
 
    @PutMapping("/update/employedby/{reviewerId}")
    public ResponseEntity<Reviewer> updateReviewerEmployedBy(@PathVariable Long reviewerId, @RequestBody String employedBy) {
        return ResponseEntity.ok(reviewerService.updateEmployedBy(reviewerId, employedBy));
    }
}