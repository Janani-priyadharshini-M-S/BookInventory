package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Author;
import com.example.bookInventory.service.AuthorService;

public class AuthorServiceTest {

    AuthorService authorService = mock(AuthorService.class);

    @Test
    void testAddAuthor() {
        Author author = new Author(1L, "John", "Doe", "Y");
        when(authorService.addAuthor(author)).thenReturn(true);

        boolean result = authorService.addAuthor(author);
        assertTrue(result);
    }

    @Test
    void testGetAuthorById() {
        Author author = new Author(1L, "John", "Smith", "Y");
        when(authorService.getAuthorById(1L)).thenReturn(author);

        Author result = authorService.getAuthorById(1L);
        assertEquals("Smith", result.getLastName());
    }

    @Test
    void testUpdateAuthorLastName() {
        Author updatedAuthor = new Author(2L, "Carly", "Hampson", "Y");
        when(authorService.updateAuthorLastName(2L, "Hampson")).thenReturn(updatedAuthor);

        Author result = authorService.updateAuthorLastName(2L, "Hampson");
        assertNotNull(result);
        assertEquals("Hampson", result.getLastName());
        assertEquals("Carly", result.getFirstName());
    }

    @Test
    void testUpdateAuthorFirstName() {
        Author updatedAuthor = new Author(2L, "Priya", "Dharshini", "Y");
        when(authorService.updateAuthorFirstName(2L, "Priya")).thenReturn(updatedAuthor);

        Author result = authorService.updateAuthorFirstName(2L, "Priya");
        assertEquals("Priya", result.getFirstName());
    }

    @Test
    void testGetAuthors() {
        Author a1 = new Author(1L, "John", "Doe", "Y");
        Author a2 = new Author(2L, "Priya", "Dharshini", "Y");
        List<Author> authors = Arrays.asList(a1, a2);

        when(authorService.getAuthors()).thenReturn(authors);

        List<Author> result = authorService.getAuthors();
        assertEquals(2, result.size());
        assertEquals("Priya", result.get(1).getFirstName());
    }

    @Test
    void testGetAuthorByFirstName() {
        Author author = new Author(1L, "Priya", "Dharshini", "Y");
        when(authorService.getAuthorByFirstName("Priya")).thenReturn(Arrays.asList(author));

        List<Author> result = authorService.getAuthorByFirstName("Priya");
        assertEquals(1, result.size());
        assertEquals("Priya", result.get(0).getFirstName());
    }

    @Test
    void testGetAuthorByLastName() {
        Author author = new Author(1L, "Priya", "Dharshini", "Y");
        when(authorService.getAuthorByLastName("Dharshini")).thenReturn(Arrays.asList(author));

        List<Author> result = authorService.getAuthorByLastName("Dharshini");
        assertEquals(1, result.size());
        assertEquals("Dharshini", result.get(0).getLastName());
    }

    @Test
    void testGetBookByAuthorId() {
        Author author = new Author(1L, "Priya", "Dharshini", "Y");
        when(authorService.getBookByAuthorId(1L)).thenReturn(Arrays.asList(author));

        List<Author> result = authorService.getBookByAuthorId(1L);
        assertEquals(1, result.size());
        assertEquals("Priya", result.get(0).getFirstName());
    }
}