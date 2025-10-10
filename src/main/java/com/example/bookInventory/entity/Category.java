package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatID")
    private Integer catId;

    @Column(name = "CatDescription", length = 24)
    private String catDescription;

    public Category() {}

    public Category(Integer catId, String catDescription) {
        this.catId = catId;
        this.catDescription = catDescription;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    @Override
    public String toString() {
        return "Category [catId=" + catId + ", catDescription=" + catDescription + "]";
    }
}