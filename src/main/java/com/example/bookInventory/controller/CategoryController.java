package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Category;
import com.example.bookInventory.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //1
    @PostMapping("/post")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category saved = categoryService.save(category);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long catId) {
        Category category = categoryService.getById(catId);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/update/description/{catId}")
    public ResponseEntity<Category> updateCategoryDescription(@PathVariable Long catId, @RequestBody Category updatedCategory) {
        Category category = categoryService.getById(catId);
        category.setCatDescription(updatedCategory.getCatDescription());
        return ResponseEntity.ok(categoryService.save(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long catId) {
        categoryService.deleteById(catId);
        return ResponseEntity.noContent().build();
    }
}


//1 post output message 


