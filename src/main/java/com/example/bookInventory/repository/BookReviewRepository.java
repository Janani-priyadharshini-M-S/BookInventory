
package com.example.bookInventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bookInventory.entity.BookReview;
 
 
@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    BookReview findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    
}
