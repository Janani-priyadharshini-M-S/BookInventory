package com.example.bookInventory.service;
 
import com.example.bookInventory.entity.Reviewer;
import java.util.List;
 
public interface ReviewerService {
    Reviewer save(Reviewer reviewer);
    Reviewer getById(Long reviewerId);
    List<Reviewer> getAll();
    Reviewer updateName(Long reviewerId, String name);
    Reviewer updateEmployedBy(Long reviewerId, String employedBy);
    boolean saveReviewerIfNotExists(Reviewer reviewer);
}