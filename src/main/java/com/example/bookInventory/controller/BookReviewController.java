
package com.example.bookInventory.controller;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.service.BookReviewService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/bookreview")
public class BookReviewController {
 
    @Autowired
    private BookReviewService bookReviewService;
    
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addBookReview(@RequestBody BookReview bookReview) {
        boolean isAdded = bookReviewService.addBookReviewIfNotExists(bookReview); // Update service method

        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("code", "POSTSUCCESS");
            response.put("message", "Book review added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "Book review already exists");
            return ResponseEntity.status(409).body(response);
        }
    }
    
    
    @GetMapping()
    public ResponseEntity<List<BookReview>> getAllBook() {
        return ResponseEntity.ok(bookReviewService.getAllBook());
    }
    
    @GetMapping("/{isbn}")
    public ResponseEntity<BookReview> getBookReviewByIsbn(@PathVariable String isbn) {
        BookReview review = bookReviewService.getBookReviewByIsbn(isbn);
        return ResponseEntity.ok(review);
    }
 
    @PutMapping("/update/rating/{isbn}")
    public ResponseEntity<BookReview> updateRating(@PathVariable String isbn, @RequestBody Integer rating) {
        BookReview updatedReview = bookReviewService.updateRatingByIsbn(isbn, rating);
        return ResponseEntity.ok(updatedReview);
    }
 
    @PutMapping("/update/comments/{isbn}")
    public ResponseEntity<BookReview> updateComments(@PathVariable String isbn, @RequestBody String comments) {
        BookReview updatedReview = bookReviewService.updateCommentsByIsbn(isbn, comments);
        return ResponseEntity.ok(updatedReview);
    }
}
