package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookauthor")
public class BookAuthor {
	
	@EmbeddedId
	private BookAuthorId id;
	
	@Column(name = "PrimaryAuthor", length = 1)
	private String primaryAuthor;

	public BookAuthor() {
		super();
	}

	public BookAuthor(BookAuthorId id, String primaryAuthor) {
		super();
		this.id = id;
		this.primaryAuthor = primaryAuthor;
	}

	public BookAuthorId getId() {
		return id;
	}

	public void setId(BookAuthorId id) {
		this.id = id;
	}

	public String getPrimaryAuthor() {
		return primaryAuthor;
	}

	public void setPrimaryAuthor(String primaryAuthor) {
		this.primaryAuthor = primaryAuthor;
	}

	@Override
	public String toString() {
		return "BookAuthor [id=" + id + ", primaryAuthor=" + primaryAuthor + "]";
	}
	
	
}