package com.example.bookInventory.controller;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.service.BookReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookreview")
public class BookReviewController {

    @Autowired
    private BookReviewService bookReviewService;

    @PostMapping("/post")
    public ResponseEntity<BookReview> addBookReview(@RequestBody BookReview bookReview) {
        BookReview savedReview = bookReviewService.addBookReview(bookReview);
        return ResponseEntity.ok(savedReview);
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