package com.example.bookInventory.service;
 
import java.util.List;
 
import com.example.bookInventory.entity.Book;
public interface BookService {
	Book addBook(Book book);
	List<Book> getAllBooks();
	Book getBookByIsbn(String isbn);
	List<Book> getBooksByTitle(String title);
	List<Book> getBooksByCategory(Integer category);
	List<Book> getBooksByPublisherId(Integer publisherId);
	Book updateBookTitle(String isbn, String newTitle);
	Book updateBookDescription(String isbn, String newDesc);
	Book updateBookCategory(String isbn, Integer newCategory);
	Book updateBookPublisher(String isbn, Integer newPublisher);
	boolean addBookIfNotExists(Book book);
	boolean updateBookEdition(String isbn, String newEdition);
	
	}
