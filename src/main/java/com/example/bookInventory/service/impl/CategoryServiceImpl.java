package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.Category;
import com.example.bookInventory.exception.ResourceNotFoundException;
import com.example.bookInventory.repository.CategoryRepository;
import com.example.bookInventory.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category obj) {
        return categoryRepository.save(obj);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!categoryRepository.existsById(id.intValue())) {
            throw new ResourceNotFoundException("Category not found with ID: " + id);
        }
        categoryRepository.deleteById(id.intValue());
    }
}