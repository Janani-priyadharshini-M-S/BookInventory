package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.service.BookReviewService;

public class BookReviewServiceTest {

    BookReviewService bookReviewService = mock(BookReviewService.class);

    @Test
    void testAddBookReview() {
        BookReview bookReview = new BookReview(1L, "1234", 1, 8, "Good Book");
        when(bookReviewService.addBookReview(bookReview)).thenReturn(bookReview);

        BookReview result = bookReviewService.addBookReview(bookReview);
        assertEquals(8, result.getRating());
        assertEquals("1234", result.getIsbn());
    }

    @Test
    void testUpdateRatingByIsbn() {
        BookReview updatedReview = new BookReview(1L, "1234", 1, 9, "Good Book");
        when(bookReviewService.updateRatingByIsbn("1234", 9)).thenReturn(updatedReview);

        BookReview result = bookReviewService.updateRatingByIsbn("1234", 9);
        assertEquals(9, result.getRating());
    }

    @Test
    void testUpdateCommentsByIsbn() {
        BookReview updatedReview = new BookReview(1L, "1234", 1, 8, "Excellent Book");
        when(bookReviewService.updateCommentsByIsbn("1234", "Excellent Book")).thenReturn(updatedReview);

        BookReview result = bookReviewService.updateCommentsByIsbn("1234", "Excellent Book");
        assertEquals("Excellent Book", result.getComments());
    }

    @Test
    void testAddBookReviewIfNotExists() {
        BookReview bookReview = new BookReview(1L, "1234", 1, 8, "Good Book");
        when(bookReviewService.addBookReviewIfNotExists(bookReview)).thenReturn(true);

        boolean result = bookReviewService.addBookReviewIfNotExists(bookReview);
        assertEquals(true, result);
    }

    @Test
    void testGetBookReviewByIsbn() {
        BookReview bookReview = new BookReview(1L, "1234", 1, 8, "Good Book");
        when(bookReviewService.getBookReviewByIsbn("1234")).thenReturn(bookReview);

        BookReview result = bookReviewService.getBookReviewByIsbn("1234");
        assertEquals("1234", result.getIsbn());
        assertEquals(8, result.getRating());
    }

    @Test
    void testGetAllBookReviews() {
        BookReview review1 = new BookReview(1L, "1234", 1, 8, "Good Book");
        BookReview review2 = new BookReview(2L, "5678", 2, 9, "Excellent Book");
        List<BookReview> reviews = Arrays.asList(review1, review2);

        when(bookReviewService.getAllBook()).thenReturn(reviews);

        List<BookReview> result = bookReviewService.getAllBook();
        assertEquals(2, result.size());
        assertEquals("5678", result.get(1).getIsbn());
    }
}