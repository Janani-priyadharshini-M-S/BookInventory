package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.BookAuthor;
import com.example.bookInventory.entity.BookAuthorId;
import com.example.bookInventory.repository.BookAuthorRepository;
import com.example.bookInventory.service.BookAuthorService;

@Service
public class BookAuthorServiceImpl implements BookAuthorService{
	
	@Autowired
	private BookAuthorRepository bookAuthorRepository;
	
	@Override
	public List<BookAuthor> getAllBookAuthor() {
		return bookAuthorRepository.findAll();
	}

	@Override
	public void assignAuthorToBook(String isbn, Long authorId, String primaryAuthorFlag) {
		// TODO Auto-generated method stub

		BookAuthorId id = new BookAuthorId(isbn, authorId);
        BookAuthor bookAuthor = new BookAuthor(id, primaryAuthorFlag);
        bookAuthorRepository.save(bookAuthor);

	}

	@Override
	public void removeAuthorFromBook(String isbn, Long authorId) {
		// TODO Auto-generated method stub
		
	}

}
