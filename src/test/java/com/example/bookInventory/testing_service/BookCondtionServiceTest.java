package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.BookCondition;
import com.example.bookInventory.service.BookConditionService;

public class BookCondtionServiceTest {

    BookConditionService bookConditionService = mock(BookConditionService.class);

    @Test
    void testSaveBookCondition() {
        BookCondition bookCondition = new BookCondition(1, "Good", "Good Book", BigDecimal.valueOf(100.00));
        when(bookConditionService.save(bookCondition)).thenReturn(bookCondition);

        BookCondition result = bookConditionService.save(bookCondition);
        assertEquals("Good Book", result.getFullDescription());
    }

    @Test
    void testGetByRanks() {
        BookCondition bookCondition = new BookCondition(1, "Good", "Good Book", BigDecimal.valueOf(100.00));
        when(bookConditionService.getByRanks(1)).thenReturn(bookCondition);

        BookCondition result = bookConditionService.getByRanks(1);
        assertEquals("Good", result.getDescription());
    }

    @Test
    void testGetAllBookConditions() {
        BookCondition book1 = new BookCondition(1, "Good", "Good Book", BigDecimal.valueOf(100.00));
        BookCondition book2 = new BookCondition(2, "Fair", "Fair Book", BigDecimal.valueOf(80.00));
        List<BookCondition> bookList = Arrays.asList(book1, book2);

        when(bookConditionService.getAll()).thenReturn(bookList);

        List<BookCondition> result = bookConditionService.getAll();
        assertEquals(2, result.size());
        assertEquals("Fair Book", result.get(1).getFullDescription());
    }

    @Test
    void testUpdatePrice() {
        BookCondition updatedBook = new BookCondition(1, "Good", "Good Book", BigDecimal.valueOf(120.00));
        when(bookConditionService.updatePrice(1, BigDecimal.valueOf(120.00))).thenReturn(updatedBook);

        BookCondition result = bookConditionService.updatePrice(1, BigDecimal.valueOf(120.00));
        assertEquals(BigDecimal.valueOf(120.00), result.getPrice());
    }

    @Test
    void testUpdateDescription() {
        BookCondition updatedBook = new BookCondition(1, "Excellent", "Good Book", BigDecimal.valueOf(100.00));
        when(bookConditionService.updateDescription(1, "Excellent")).thenReturn(updatedBook);

        BookCondition result = bookConditionService.updateDescription(1, "Excellent");
        assertEquals("Excellent", result.getDescription());
    }

    @Test
    void testUpdateFullDescription() {
        BookCondition updatedBook = new BookCondition(1, "Good", "Excellent Book", BigDecimal.valueOf(100.00));
        when(bookConditionService.updateFullDescription(1, "Excellent Book")).thenReturn(updatedBook);

        BookCondition result = bookConditionService.updateFullDescription(1, "Excellent Book");
        assertEquals("Excellent Book", result.getFullDescription());
    }

    @Test
    void testExistsByRanks() {
        when(bookConditionService.existsByRanks(1)).thenReturn(true);

        boolean result = bookConditionService.existsByRanks(1);
        assertEquals(true, result);
    }
}