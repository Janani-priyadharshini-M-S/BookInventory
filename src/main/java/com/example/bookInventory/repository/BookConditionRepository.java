package com.example.bookInventory.repository;

import com.example.bookInventory.entity.BookCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookConditionRepository extends JpaRepository<BookCondition, Integer> {
    // You can add custom query methods here if needed
}