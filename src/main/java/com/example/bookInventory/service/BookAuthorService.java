package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.BookAuthor;

public interface BookAuthorService {
	public void assignAuthorToBook(String isbn, Long authorId, String primaryAuthorFlag);
	public void removeAuthorFromBook(String isbn, Long authorId);
	List<BookAuthor> getAllBookAuthor();
}
