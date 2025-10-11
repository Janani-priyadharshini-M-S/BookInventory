
package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.PurchaseLog;

public interface PurchaseLogRepository extends JpaRepository<PurchaseLog, Integer>{

	PurchaseLog getByUserId(Integer userId);

}
