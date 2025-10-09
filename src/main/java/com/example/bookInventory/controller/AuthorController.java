package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Author;
import com.example.bookInventory.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> getAuthor(){
		return ResponseEntity.ok(authorService.getAuthors());
	}
	
	@PostMapping 
	public ResponseEntity<Author> addAuthor(@RequestBody Author author){
		return ResponseEntity.ok(authorService.addAuthor(author));
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId){
		return ResponseEntity.ok(authorService.getAuthorById(authorId));
	}
	@GetMapping("/firstname/{firstName}")
	public ResponseEntity<List<Author>> getAuthorsByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok(authorService.getAuthorByFirstName(firstName));
	}
	@GetMapping("/lastname/{lastName}")
	public ResponseEntity<List<Author>> getAuthorsByLastName(@PathVariable String lastName){
		return ResponseEntity.ok(authorService.getAuthorByLastName(lastName));
	}
	@PutMapping("/update/firstName/{authorId}")
	public ResponseEntity<Author> updateFirstName(@PathVariable Long authorId,@RequestBody String firstName){
		return ResponseEntity.ok(authorService.updateAuthorFirstName(authorId, firstName));
	}
	@PutMapping("/update/lastName/{authorId}")
	public ResponseEntity<Author> updateLastName(@PathVariable Long authorId,@RequestBody String lastName){
		return ResponseEntity.ok(authorService.updateAuthorLastName(authorId, lastName));
	}
//	@GetMapping("/books/{authorId}")
//	public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable Long authorId){
//		return ResponseEntity.ok(authorService.getBooksByAuthorId(authorId));
//	}

}
