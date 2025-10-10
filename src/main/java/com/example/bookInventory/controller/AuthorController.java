package com.example.bookInventory.controller;
 
import com.example.bookInventory.entity.Author;
import com.example.bookInventory.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map; 

@RestController
@RequestMapping("/api/author")

public class AuthorController {
    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public ResponseEntity<List<Author>> getAuthor() {
        return ResponseEntity.ok(authorService.getAuthors());
    }
    
    //1
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addAuthor(@RequestBody Author author) {
        boolean isAdded = authorService.addAuthor(author); // You must update service to return boolean
        Map<String, String> response = new HashMap<>();
        if (isAdded) {
            response.put("code", "POSTSUCCESS");
            response.put("message", "Author added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "Author already exist");
            return ResponseEntity.status(409).body(response);
        }
    }
    //2
    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }
    
    //3
    @GetMapping("/firstname/{firstName}")
    public ResponseEntity<List<Author>> getAuthorsByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(authorService.getAuthorByFirstName(firstName));
    }
    
    //4
    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<Author>> getAuthorsByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(authorService.getAuthorByLastName(lastName));
    }
    
    //5
    @PutMapping("/update/firstName/{authorId}")
    public ResponseEntity<Author> updateFirstName(@PathVariable Long authorId, @RequestBody String firstName) {
       return ResponseEntity.ok(authorService.updateAuthorFirstName(authorId, firstName));
    }
    
    //6
    @PutMapping("/update/lastName/{authorId}")
    public ResponseEntity<Author> updateLastName(@PathVariable Long authorId, @RequestBody String lastName) {
        return ResponseEntity.ok(authorService.updateAuthorLastName(authorId, lastName));
    }
 
    // Uncomment if needed
    // @GetMapping("/books/{authorId}")
    // public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable Long authorId){
    //     return ResponseEntity.ok(authorService.getBooksByAuthorId(authorId));
    // }

}
 
