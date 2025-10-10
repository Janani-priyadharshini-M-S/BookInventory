package com.example.bookInventory.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bookInventory.entity.Book;
import com.example.bookInventory.service.BookService;
 
@RestController
@RequestMapping("/api/book")
public class BookController {
 
    @Autowired
    BookService bookService;
 
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addBook(@RequestBody Book book) {
        boolean isAdded = bookService.addBookIfNotExists(book);
 
        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("code", "POSTSUCCESS");
            response.put("message", "Book added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "Book already exists");
            return ResponseEntity.status(409).body(response);
        }
    }
 
    @PutMapping("/update/edition/{isbn}")
    public ResponseEntity<Map<String, String>> updateEdition(@PathVariable String isbn, @RequestBody String newEdition) {
        boolean isUpdated = bookService.updateBookEdition(isbn, newEdition);
 
        Map<String, String> response = new HashMap<>();
        if (isUpdated) {
            response.put("code", "UPDATESUCCESS");
            response.put("message", "Edition updated successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "UPDATEFAIL");
            response.put("message", "Book not found or update failed");
            return ResponseEntity.status(404).body(response);
        }
    }
 
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
 
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
    }
 
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }
 
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Book>> getBookByCategory(@PathVariable Integer category) {
        return ResponseEntity.ok(bookService.getBooksByCategory(category));
    }
 
    @GetMapping("/publisher/{publisherId}")
    public ResponseEntity<List<Book>> getBookByPublisherId(@PathVariable Integer publisherId) {
        return ResponseEntity.ok(bookService.getBooksByPublisherId(publisherId));
    }
 
    @PutMapping("/update/title/{isbn}")
    public ResponseEntity<Book> updateTitle(@PathVariable String isbn, @RequestBody String newTitle) {
        return ResponseEntity.ok(bookService.updateBookTitle(isbn, newTitle));
    }
 
    @PutMapping("/update/description/{isbn}")
    public ResponseEntity<Book> updateDescription(@PathVariable String isbn, @RequestBody String newDesc) {
        return ResponseEntity.ok(bookService.updateBookDescription(isbn, newDesc));
    }
 
    @PutMapping("/update/category/{isbn}")
    public ResponseEntity<Book> updateCategory(@PathVariable String isbn, @RequestBody Integer newCategory) {
        return ResponseEntity.ok(bookService.updateBookCategory(isbn, newCategory));
    }
 
    @PutMapping("/update/publisher/{isbn}")
    public ResponseEntity<Book> updatePublisher(@PathVariable String isbn, @RequestBody Integer newPublisher) {
        return ResponseEntity.ok(bookService.updateBookPublisher(isbn, newPublisher));
    }
    
    @GetMapping
    public ResponseEntity<List<Book>> getAuthor() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    
}