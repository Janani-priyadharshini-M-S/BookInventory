package com.example.bookInventory.repository;

import com.example.bookInventory.entity.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
    // You can add custom query methods if needed
	boolean existsByNameAndEmployedBy(String name, String employedBy);
}