package com.example.bookInventory.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookAuthorId {

	private String isbn;
	private Long authorId;
	
	
	public BookAuthorId() {
		super();
	}


	public BookAuthorId(String isbn, Long authorId) {
		super();
		this.isbn = isbn;
		this.authorId = authorId;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Long getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(authorId, isbn);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAuthorId other = (BookAuthorId) obj;
		return Objects.equals(authorId, other.authorId) && Objects.equals(isbn, other.isbn);
	}


	@Override
	public String toString() {
		return "BookAuthorId [isbn=" + isbn + ", authorId=" + authorId + "]";
	}
	
	
}