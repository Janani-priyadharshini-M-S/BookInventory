package com.example.bookInventory.service;

import com.example.bookInventory.entity.BookCondition;

import java.math.BigDecimal;
import java.util.List;

public interface BookConditionService {
    BookCondition save(BookCondition bookCondition);
    BookCondition getByRanks(Integer ranks);
    List<BookCondition> getAll();
    BookCondition updatePrice(Integer ranks, BigDecimal price);
    BookCondition updateDescription(Integer ranks, String description);
    BookCondition updateFullDescription(Integer ranks, String fullDescription);
    boolean existsByRanks(Integer ranks);
}
  