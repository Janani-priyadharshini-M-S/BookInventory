package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.repository.BookReviewRepository;
import com.example.bookInventory.service.BookReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReviewServiceImpl implements BookReviewService {

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Override
    public BookReview addBookReview(BookReview bookReview) {
        return bookReviewRepository.save(bookReview);
    }

    @Override
    public BookReview getBookReviewByIsbn(String isbn) {
        return bookReviewRepository.findByIsbn(isbn);
    }

    @Override
    public BookReview updateRatingByIsbn(String isbn, Integer rating) {
        BookReview review = getBookReviewByIsbn(isbn);
        review.setRating(rating);
        return bookReviewRepository.save(review);
    }

    @Override
    public BookReview updateCommentsByIsbn(String isbn, String comments) {
        BookReview review = getBookReviewByIsbn(isbn);
        review.setComments(comments);
        return bookReviewRepository.save(review);
    }
}