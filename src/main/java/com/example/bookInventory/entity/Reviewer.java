package com.example.bookInventory.entity;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "reviewer")
public class Reviewer {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewerID")
    private Long reviewerId;
 
    @Column(name = "Name", length = 20, nullable = false)
    private String name;
 
    @Column(name = "EmployedBy", length = 30)
    private String employedBy;
 
    public Reviewer() {}
 
    public Reviewer(Long reviewerId, String name, String employedBy) {
        this.reviewerId = reviewerId;
        this.name = name;
        this.employedBy = employedBy;
    }
 
    public Long getReviewerId() {
        return reviewerId;
    }
 
    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmployedBy() {
        return employedBy;
    }
 
    public void setEmployedBy(String employedBy) {
        this.employedBy = employedBy;
    }
 
    @Override
    public String toString() {
        return "Reviewer [reviewerId=" + reviewerId + ", name=" + name + ", employedBy=" + employedBy + "]";
    }
}