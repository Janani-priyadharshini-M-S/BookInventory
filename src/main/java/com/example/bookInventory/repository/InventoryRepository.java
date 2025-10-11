

package com.example.bookInventory.repository;

import com.example.bookInventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	boolean existsByInventoryId(Long inventoryId);
    // You can add custom query methods if needed	boolean existsByInventoryId(Long inventoryId);
	   
}
