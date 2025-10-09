package com.example.bookInventory.service.impl;
 
import com.example.bookInventory.service.AuthorService;
import com.example.bookInventory.entity.Author;
import com.example.bookInventory.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class AuthorServiceImpl implements AuthorService {
 
    @Autowired
    private AuthorRepository authorRepository;
 
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
 
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
 
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + authorId));
    }
 
    public List<Author> getAuthorByFirstName(String firstName) {
        return authorRepository.findByFirstNameIgnoreCase(firstName);
    }
 
    public List<Author> getAuthorByLastName(String lastName) {
        return authorRepository.findByLastNameIgnoreCase(lastName);
    }
 
    public Author updateAuthorFirstName(Long authorId, String firstName) {
        Author author = getAuthorById(authorId);
        author.setFirstName(firstName);
        return authorRepository.save(author);
    }
 
    public Author updateAuthorLastName(Long authorId, String lastName) {
        Author author = getAuthorById(authorId);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }
 
    public List<Author> getBookByAuthorId(Long authorId) {
        // Assuming you have a method in repository or a join with BookAuthor
        //return authorRepository.findBooksByAuthorId(authorId);
    	return null;
    }
}