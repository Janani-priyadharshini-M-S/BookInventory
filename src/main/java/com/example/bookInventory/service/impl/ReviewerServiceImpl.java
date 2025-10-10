package com.example.bookInventory.service.impl;


import com.example.bookInventory.entity.Reviewer;
import com.example.bookInventory.exception.ResourceNotFoundException;
import com.example.bookInventory.repository.ReviewerRepository;
import com.example.bookInventory.service.ReviewerService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class ReviewerServiceImpl implements ReviewerService {
 
    @Autowired
    private ReviewerRepository reviewerRepository;
    @Override
    public boolean saveReviewerIfNotExists(Reviewer reviewer) {
        boolean exists = reviewerRepository.existsByNameAndEmployedBy(
            reviewer.getName(), reviewer.getEmployedBy()
        );
 
        if (exists) {
            return false;
        }
 
        reviewerRepository.save(reviewer);
        return true;
    }
 
    @Override
    public Reviewer save(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }
 
    @Override
    public Reviewer getById(Long reviewerId) {
        return reviewerRepository.findById(reviewerId)
                .orElseThrow(() -> new ResourceNotFoundException("Reviewer not found with ID: " + reviewerId));
    }
 
    @Override
    public List<Reviewer> getAll() {
        return reviewerRepository.findAll();
    }
 
    @Override
    public Reviewer updateName(Long reviewerId, String name) {
        Reviewer reviewer = getById(reviewerId);
        reviewer.setName(name);
        return reviewerRepository.save(reviewer);
    }
 
    @Override
    public Reviewer updateEmployedBy(Long reviewerId, String employedBy) {
        Reviewer reviewer = getById(reviewerId);
        reviewer.setEmployedBy(employedBy);
        return reviewerRepository.save(reviewer);
    }
}