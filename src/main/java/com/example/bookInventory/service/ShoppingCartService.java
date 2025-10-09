package com.example.bookInventory.service;


import java.util.List;
import com.example.bookInventory.entity.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart addToCart(ShoppingCart cartItem); // POST /api/shoppingcart/post

    List<ShoppingCart> getCartByUserId(Integer userId); // GET /api/shoppingcart/{userId}

    ShoppingCart updateIsbnByUserId(Integer userId, String newIsbn); // PUT /api/shoppingcart/update/isbn/{userId}
}
