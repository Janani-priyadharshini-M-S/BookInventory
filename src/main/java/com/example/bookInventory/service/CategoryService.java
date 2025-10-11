package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.Category;

public interface CategoryService {
    Category save(Category obj);
    Category getById(Long id);
    List<Category> getAll();
    void deleteById(Long id);
}