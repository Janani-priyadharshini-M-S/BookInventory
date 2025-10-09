package com.example.bookInventory.controller;

import com.example.bookInventory.entity.ShoppingCart;
import com.example.bookInventory.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    // POST: Add new shopping cart object
    @PostMapping("/post")
    public ResponseEntity<String> addToCart(@RequestBody ShoppingCart cartItem) {
        shoppingCartService.addToCart(cartItem);
        return ResponseEntity.ok("Shopping cart added successfully");
    }

    // GET: Get cart items by userId
    @GetMapping("/{userId}")
    public ResponseEntity<List<ShoppingCart>> getCartByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(shoppingCartService.getCartByUserId(userId));
    }

    // PUT: Update ISBN for a given userId
    @PutMapping("/update/isbn/{userId}")
    public ResponseEntity<ShoppingCart> updateIsbnByUserId(@PathVariable Integer userId, @RequestBody String newIsbn) {
        return ResponseEntity.ok(shoppingCartService.updateIsbnByUserId(userId, newIsbn));
    }
}