package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.BookReview;

public interface BookReviewService {
    BookReview addBookReview(BookReview bookReview);
    BookReview getBookReviewByIsbn(String isbn);
    BookReview updateRatingByIsbn(String isbn, Integer rating);
    BookReview updateCommentsByIsbn(String isbn, String comments);
    boolean addBookReviewIfNotExists(BookReview bookReview);
	List<BookReview> getAllBook();
}