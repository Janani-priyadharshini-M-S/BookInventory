package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Book;
import com.example.bookInventory.service.BookService;

public class BookServiceTest {

    BookService bookService = mock(BookService.class);

    @Test
    void testAddBook() {
        Book book = new Book("123", "Books", "Nice Story", 4, "1", 2);
        when(bookService.addBook(book)).thenReturn(book);

        Book result = bookService.addBook(book);
        assertEquals("Books", result.getTitle());
        assertEquals("Nice Story", result.getDescription());
    }

    @Test
    void testGetBookByIsbn() {
        Book book = new Book("123", "Sherlock", "Detective", 4, "1", 2);
        when(bookService.getBookByIsbn("123")).thenReturn(book);

        Book result = bookService.getBookByIsbn("123");
        assertEquals("Sherlock", result.getTitle());
    }

    @Test
    void testUpdateBookTitle() {
        Book updatedBook = new Book("123", "Sherlock Holmes", "Detective", 4, "1", 2);
        when(bookService.updateBookTitle("123", "Sherlock Holmes")).thenReturn(updatedBook);

        Book result = bookService.updateBookTitle("123", "Sherlock Holmes");
        assertEquals("Sherlock Holmes", result.getTitle());
    }

    @Test
    void testUpdateBookDescription() {
        Book updatedBook = new Book("123", "Sherlock", "Mystery Thriller", 4, "1", 2);
        when(bookService.updateBookDescription("123", "Mystery Thriller")).thenReturn(updatedBook);

        Book result = bookService.updateBookDescription("123", "Mystery Thriller");
        assertEquals("Mystery Thriller", result.getDescription());
    }

    @Test
    void testUpdateBookCategory() {
        Book updatedBook = new Book("123", "Sherlock", "Detective", 5, "1", 2);
        when(bookService.updateBookCategory("123", 5)).thenReturn(updatedBook);

        Book result = bookService.updateBookCategory("123", 5);
        assertEquals(5, result.getCategory());
    }

    @Test
    void testUpdateBookPublisher() {
        Book updatedBook = new Book("123", "Sherlock", "Detective", 4, "1", 3);
        when(bookService.updateBookPublisher("123", 3)).thenReturn(updatedBook);

        Book result = bookService.updateBookPublisher("123", 3);
        assertEquals(3, result.getPublisherId());
    }

    @Test
    void testUpdateBookEdition() {
        when(bookService.updateBookEdition("123", "2nd Edition")).thenReturn(true);

        boolean result = bookService.updateBookEdition("123", "2nd Edition");
        assertEquals(true, result);
    }

    @Test
    void testAddBookIfNotExists() {
        Book book = new Book("123", "Books", "Nice Story", 4, "1", 2);
        when(bookService.addBookIfNotExists(book)).thenReturn(true);

        boolean result = bookService.addBookIfNotExists(book);
        assertEquals(true, result);
    }

    @Test
    void testGetBooksByTitle() {
        Book book1 = new Book("123", "Sherlock", "Detective", 4, "1", 2);
        Book book2 = new Book("456", "Sherlock", "Mystery", 4, "2", 3);
        List<Book> books = Arrays.asList(book1, book2);

        when(bookService.getBooksByTitle("Sherlock")).thenReturn(books);

        List<Book> result = bookService.getBooksByTitle("Sherlock");
        assertEquals(2, result.size());
    }

    @Test
    void testGetBooksByCategory() {
        Book book1 = new Book("123", "Sherlock", "Detective", 4, "1", 2);
        Book book2 = new Book("456", "Mystery Tales", "Thriller", 4, "2", 3);
        List<Book> books = Arrays.asList(book1, book2);

        when(bookService.getBooksByCategory(4)).thenReturn(books);

        List<Book> result = bookService.getBooksByCategory(4);
        assertEquals(2, result.size());
    }

    @Test
    void testGetBooksByPublisherId() {
        Book book1 = new Book("123", "Sherlock", "Detective", 4, "1", 2);
        Book book2 = new Book("789", "Adventure", "Exciting", 3, "1", 2);
        List<Book> books = Arrays.asList(book1, book2);

        when(bookService.getBooksByPublisherId(2)).thenReturn(books);

        List<Book> result = bookService.getBooksByPublisherId(2);
        assertEquals(2, result.size());
    }

    @Test
    void testGetAllBooks() {
        Book book1 = new Book("123", "Sherlock", "Detective", 4, "1", 2);
        Book book2 = new Book("456", "Mystery Tales", "Thriller", 4, "2", 3);
        List<Book> books = Arrays.asList(book1, book2);

        when(bookService.getAllBooks()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();
        assertEquals(2, result.size());
    }
}