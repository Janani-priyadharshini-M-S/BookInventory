package com.example.bookInventory.entity;
 
import jakarta.persistence.*;

 
@Entity
@Table(name = "book")
 
public class Book {
 
    public Book() {
		super();
	}
 
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", edition=" + edition + ", publisherId=" + publisherId + "]";
	}
 
	public Book(String isbn, String title, String description, Integer category, String edition, Integer publisherId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.category = category;
		this.edition = edition;
		this.publisherId = publisherId;
	}
 
	public String getIsbn() {
		return isbn;
	}
 
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
 
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}
 
	public String getDescription() {
		return description;
	}
 
	public void setDescription(String description) {
		this.description = description;
	}
 
	public Integer getCategory() {
		return category;
	}
 
	public void setCategory(Integer category) {
		this.category = category;
	}
 
	public String getEdition() {
		return edition;
	}
 
	public void setEdition(String edition) {
		this.edition = edition;
	}
 
	public Integer getPublisherId() {
		return publisherId;
	}
 
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
 
	@Id
    @Column(name = "ISBN", length = 13)
    private String isbn;
 
    @Column(name = "Title", length = 70, nullable = false)
    private String title;
 
    @Column(name = "Description", length = 100)
    private String description;
 
    @Column(name = "Category")
    private Integer category;
 
    @Column(name = "Edition", length = 30)
    private String edition;
 
    @Column(name = "PublisherID")
    private Integer publisherId;
}
 