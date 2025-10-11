
package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryID")
    private Long inventoryId;

    @Column(name = "ISBN", length = 13, nullable = false)
    private String isbn;

    @Column(name = "Ranks", nullable = false)
    private Integer ranks;

    @Column(name = "Purchased", nullable = false)
    private Boolean purchased;



    public Inventory() {}

    public Inventory(Long inventoryId, String isbn, Integer ranks, Boolean purchased, Long bookId) {
        this.inventoryId = inventoryId;
        this.isbn = isbn;
        this.ranks = ranks;
        this.purchased = purchased;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getRanks() {
        return ranks;
    }

    public void setRanks(Integer ranks) {
        this.ranks = ranks;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

 

    @Override
    public String toString() {
        return "Inventory [inventoryId=" + inventoryId + ", isbn=" + isbn +
               ", ranks=" + ranks + ", purchased=" + purchased + "]";
    }
}
