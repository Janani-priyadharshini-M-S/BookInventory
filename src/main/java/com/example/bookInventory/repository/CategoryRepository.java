package com.example.bookInventory.repository;

import com.example.bookInventory.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // You can add custom query methods if needed
}