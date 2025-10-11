package com.example.bookInventory.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bookcondition")
public class BookCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ranks;

    @Column(name = "Description", length = 50)
    private String description;

    @Column(name = "FullDescription", length = 255)
    private String fullDescription;

    @Column(name = "Price", precision = 12, scale = 2)
    private BigDecimal price;

    public BookCondition() {}

    public BookCondition(Integer ranks, String description, String fullDescription, BigDecimal price) {
        this.ranks = ranks;
        this.description = description;
        this.fullDescription = fullDescription;
        this.price = price;
    }

    // Getters and Setters

    public Integer getRanks() {
        return ranks;
    }

    public void setRanks(Integer ranks) {
        this.ranks = ranks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookCondition [ranks=" + ranks + ", description=" + description +
               ", fullDescription=" + fullDescription + ", price=" + price + "]";
    }
}