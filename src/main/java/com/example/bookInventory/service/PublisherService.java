package com.example.bookInventory.service;
 
import com.example.bookInventory.entity.Publisher;
import java.util.List;
 
public interface PublisherService {
    boolean savePublisher(Publisher publisher); // ✅ updated method
    Publisher getById(Long publisherId);
    List<Publisher> getAll();
    List<Publisher> getByName(String name);
    List<Publisher> getByCity(String city);
    List<Publisher> getByState(String stateCode);
    Publisher updateName(Long publisherId, String name);
    Publisher updateCity(Long publisherId, String city);
    Publisher updateState(Long publisherId, String stateCode);
}