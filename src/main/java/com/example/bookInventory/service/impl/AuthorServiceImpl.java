package com.example.bookInventory.service.impl;
 
import com.example.bookInventory.entity.Author;
import com.example.bookInventory.exception.ResourceNotFoundException;
import com.example.bookInventory.repository.AuthorRepository;
import com.example.bookInventory.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class AuthorServiceImpl implements AuthorService {
 
    @Autowired
    private AuthorRepository authorRepository;
 
    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
 
    @Override
    public boolean addAuthor(Author author) {
        boolean exists = authorRepository.existsByFirstNameAndLastName(
            author.getFirstName(), author.getLastName()
        );
 
        if (exists) {
            return false;
        }
 
        authorRepository.save(author);
        return true;
    }
 
    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + authorId));
    }
 
    @Override
    public List<Author> getAuthorByFirstName(String firstName) {
        return authorRepository.findByFirstNameIgnoreCase(firstName);
    }
 
    @Override
    public List<Author> getAuthorByLastName(String lastName) {
        return authorRepository.findByLastNameIgnoreCase(lastName);
    }
 
    @Override
    public Author updateAuthorFirstName(Long authorId, String firstName) {
        Author author = getAuthorById(authorId);
        author.setFirstName(firstName);
        return authorRepository.save(author);
    }
 
    @Override
    public Author updateAuthorLastName(Long authorId, String lastName) {
        Author author = getAuthorById(authorId);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }
 
    @Override
    public List<Author> getBookByAuthorId(Long authorId) {
        // Placeholder for future implementation
        return null;
    }
}