
package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.PurchaseLog;

public interface PurchaseLogService {
	List<PurchaseLog> getAllLogs();
	PurchaseLog addLog(PurchaseLog purchaseLog);
	PurchaseLog getLogByUserId(Integer userId);
	PurchaseLog updateInventoryIdByUserId(Integer userId, Integer inventoryId);
}
