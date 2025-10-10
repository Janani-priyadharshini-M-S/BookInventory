package com.example.bookInventory.service;
 
import java.util.List;
 
import com.example.bookInventory.entity.Author;
 
public interface AuthorService {
	List<Author> getAuthors();
	boolean addAuthor(Author author);
		Author getAuthorById(Long authorId);
		List<Author> getAuthorByFirstName(String firstName);
		List<Author> getAuthorByLastName(String lastName);
		Author updateAuthorFirstName(Long authorId, String firstName);
		Author updateAuthorLastName(Long authorId, String lastName);
		List<Author> getBookByAuthorId(Long authorId);
}