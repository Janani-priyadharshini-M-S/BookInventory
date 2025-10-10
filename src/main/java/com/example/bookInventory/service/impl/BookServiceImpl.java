
package com.example.bookInventory.service.impl;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookInventory.entity.Book;
import com.example.bookInventory.repository.BookRepository;
import com.example.bookInventory.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;
	@Override
	public boolean addBookIfNotExists(Book book) {
	    if (bookRepository.existsByIsbn(book.getIsbn())) {
	        return false;
	    }
	    bookRepository.save(book);
	    return true;
	}
	@Override
	public boolean updateBookEdition(String isbn, String newEdition) {
	    Optional<Book> optionalBook = bookRepository.findById(isbn);
	    if (optionalBook.isPresent()) {
	        Book book = optionalBook.get();
	        book.setEdition(newEdition);
	        bookRepository.save(book);
	        return true;
	    }
	    return false;
	}
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		if(bookRepository.existsById(book.getIsbn()))
			throw new RuntimeException("Book Already Exists");
		return bookRepository.save(book);
	}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}
	@Override
	public Book getBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return bookRepository.findById(isbn).orElseThrow(()-> new RuntimeException("Book Not Found"));
	}
	@Override
	public List<Book> getBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return bookRepository.findByTitle(title);
	}
	@Override
	public List<Book> getBooksByCategory(Integer category) {
		// TODO Auto-generated method stub
		return bookRepository.findByCategory(category);
	}
	@Override
	public List<Book> getBooksByPublisherId(Integer publisherId) {
		// TODO Auto-generated method stub
		return bookRepository.findByPublisherId(publisherId);
	}
	@Override
	public Book updateBookTitle(String isbn, String newTitle) {
		// TODO Auto-generated method stub
		Book book = getBookByIsbn(isbn);
		book.setTitle(newTitle);
		bookRepository.save(book);
		return book;
	}
	@Override
	public Book updateBookDescription(String isbn, String newDesc) {
		// TODO Auto-generated method stub
		Book book = getBookByIsbn(isbn);
		book.setDescription(newDesc);
		bookRepository.save(book);
		return book;
	}
	@Override
	public Book updateBookCategory(String isbn, Integer newCategory) {
		// TODO Auto-generated method stub
		Book book = getBookByIsbn(isbn);
		book.setCategory(newCategory);
		bookRepository.save(book);
		return book;
	}
	@Override
	public Book updateBookPublisher(String isbn, Integer newPublisher) {
		// TODO Auto-generated method stub
		Book book = getBookByIsbn(isbn);
		book.setPublisherId(newPublisher);
		bookRepository.save(book);
		return book;
	}
}
