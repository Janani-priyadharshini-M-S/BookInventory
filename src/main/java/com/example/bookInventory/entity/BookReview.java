

package com.example.bookInventory.entity;
 
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "book_review")
public class BookReview {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private Long reviewId;
 
    @Column(name = "ISBN", length = 13, nullable = false)
    private String isbn;
 
    @Column(name = "ReviewerID", nullable = false)
    private Integer reviewerId;
 
    @Column(name = "Rating")
    private Integer rating;
 
    @Column(name = "Comments", length = 255)
    private String comments;
 
    public BookReview() {}
 
    public BookReview(Long reviewId, String isbn, Integer reviewerId, Integer rating, String comments) {
        this.reviewId = reviewId;
        this.isbn = isbn;
        this.reviewerId = reviewerId;
        this.rating = rating;
        this.comments = comments;
    }
 
    @Override
    public String toString() {
        return "BookReview [reviewId=" + reviewId + ", isbn=" + isbn + ", reviewerId=" + reviewerId +
               ", rating=" + rating + ", comments=" + comments + "]";
    }
 
    // Getters and Setters
    public Long getReviewId() {
    	return reviewId;
    	}
    public void setReviewId(Long reviewId) {
    	this.reviewId = reviewId;
    	}
 
    public String getIsbn() {
    	return isbn;
    	}
    public void setIsbn(String isbn) {
    	this.isbn = isbn;
    	}
 
    public Integer getReviewerId() {
    	return reviewerId;
    	}
    public void setReviewerId(Integer reviewerId) {
    	this.reviewerId = reviewerId;
    	}
 
    public Integer getRating() {
    	return rating;
    	}
    public void setRating(Integer rating) {
    	this.rating = rating;
    	}
 
    public String getComments() {
    	return comments;
    	}
    public void setComments(String comments) {
    	this.comments = comments;
    	}
}
