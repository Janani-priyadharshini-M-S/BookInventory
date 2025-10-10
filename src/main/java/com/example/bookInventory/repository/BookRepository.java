package com.example.bookInventory.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookInventory.entity.Book;
public interface BookRepository extends JpaRepository<Book, String>{
	List<Book> findByTitle(String title);
	List<Book> findByCategory(Integer category);
	List<Book> findByPublisherId(Integer publisherId);
	boolean existsByIsbn(String isbn);
}