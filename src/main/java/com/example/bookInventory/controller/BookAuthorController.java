package com.example.bookInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.BookAuthor;
import com.example.bookInventory.entity.BookAuthorId;
import com.example.bookInventory.service.BookAuthorService;

@RestController
@RequestMapping("/api/bookauthor")
public class BookAuthorController {
	@Autowired
	private BookAuthorService bookAuthorService;
	
	@GetMapping
	public ResponseEntity<List<BookAuthor>> getAllBookAuthor(){
		return ResponseEntity.ok(bookAuthorService.getAllBookAuthor());
	}
	
	
	@PostMapping("/assign")
	public ResponseEntity<String> assignAuthor(@RequestBody BookAuthorId request )
		{
		bookAuthorService.assignAuthorToBook(request.getIsbn(), request.getAuthorId(), "Y");
        return ResponseEntity.ok("Author assigned to book successfully.");
        }
	

	@DeleteMapping("/remove")
    public ResponseEntity<String> removeAuthor(@RequestParam String isbn, @RequestParam Long authorId) {
        bookAuthorService.removeAuthorFromBook(isbn, authorId);
        return ResponseEntity.ok("Author removed from book successfully.");
    }

}