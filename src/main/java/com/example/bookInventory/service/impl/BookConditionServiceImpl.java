
package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.BookCondition;
import com.example.bookInventory.exception.ResourceNotFoundException;
import com.example.bookInventory.repository.BookConditionRepository;
import com.example.bookInventory.service.BookConditionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookConditionServiceImpl implements BookConditionService {

    @Autowired
    private BookConditionRepository bookConditionRepository;
    
    @Override
    public boolean existsByRanks(Integer ranks) {
        return bookConditionRepository.existsByRanks(ranks);
    }

    @Override
    public BookCondition getByRanks(Integer ranks) {
        return bookConditionRepository.findByRanks(ranks)
            .orElseThrow(() -> new ResourceNotFoundException("Book condition not found for ranks: " + ranks));
    }

    @Override
    public BookCondition save(BookCondition bookCondition) {
        return bookConditionRepository.save(bookCondition);
    }

    @Override
    public List<BookCondition> getAll() {
        return bookConditionRepository.findAll();
    }

    @Override
    public BookCondition updatePrice(Integer ranks, BigDecimal price) {
        BookCondition condition = getByRanks(ranks);
        condition.setPrice(price);
        return bookConditionRepository.save(condition);
    }

    @Override
    public BookCondition updateDescription(Integer ranks, String description) {
        BookCondition condition = getByRanks(ranks);
        condition.setDescription(description);
        return bookConditionRepository.save(condition);
    }

    @Override
    public BookCondition updateFullDescription(Integer ranks, String fullDescription) {
        BookCondition condition = getByRanks(ranks);
        condition.setFullDescription(fullDescription);
        return bookConditionRepository.save(condition);
    }
}
