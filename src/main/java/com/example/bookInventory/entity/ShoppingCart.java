package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private Long cartId;

    @Column(name = "UserID", nullable = false)
    private Integer userId;

    @Column(name = "isbn", length = 13, nullable = false)
    private String isbn;

    public ShoppingCart() {
        super();
    }

    public ShoppingCart(Long cartId, Integer userId, String isbn) {
        super();
        this.cartId = cartId;
        this.userId = userId;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "ShoppingCart [cartId=" + cartId + ", userId=" + userId + ", isbn=" + isbn + "]";
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}