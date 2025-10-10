package com.example.bookInventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.BookAuthor;
import com.example.bookInventory.entity.BookAuthorId;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId> {

	List<BookAuthor> findByIdAuthorId(Long authorId);

}
