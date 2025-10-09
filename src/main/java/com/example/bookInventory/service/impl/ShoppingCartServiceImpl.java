package com.example.bookInventory.service.impl;


import com.example.bookInventory.entity.ShoppingCart;
import com.example.bookInventory.repository.ShoppingCartRepository;
import com.example.bookInventory.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart addToCart(ShoppingCart cartItem) {
        return shoppingCartRepository.save(cartItem);
    }

    @Override
    public List<ShoppingCart> getCartByUserId(Integer userId) {
        return shoppingCartRepository.findByUserId(userId);
    }

    @Override
    public ShoppingCart updateIsbnByUserId(Integer userId, String newIsbn) {
        List<ShoppingCart> cartItems = shoppingCartRepository.findByUserId(userId);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("No cart items found for UserID: " + userId);
        }

        // Assuming we update the first matching cart item
        ShoppingCart cartItem = cartItems.get(0);
        cartItem.setIsbn(newIsbn);
        return shoppingCartRepository.save(cartItem);
    }
}
