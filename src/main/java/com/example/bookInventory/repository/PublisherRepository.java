package com.example.bookInventory.repository;
 
import com.example.bookInventory.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import java.util.List;
 
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
 
    List<Publisher> findByNameIgnoreCase(String name);
 
    List<Publisher> findByCityIgnoreCase(String city);
 
    List<Publisher> findByStateCodeIgnoreCase(String stateCode);
 
	boolean existsByNameAndCityAndStateCode(String name, String city, String stateCode);
}