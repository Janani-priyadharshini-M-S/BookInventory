package com.example.bookInventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.example.bookInventory.entity.Author;
 
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
 
	List<Author> findByFirstNameIgnoreCase(String firstName);
 
	List<Author> findByLastNameIgnoreCase(String lastName);
 
	List<Author> findBooks_ByAuthorId(Long authorId);
}
