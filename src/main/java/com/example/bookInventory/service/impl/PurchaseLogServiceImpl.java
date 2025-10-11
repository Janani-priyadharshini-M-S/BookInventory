
package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.PurchaseLog;
import com.example.bookInventory.repository.PurchaseLogRepository;
import com.example.bookInventory.service.PurchaseLogService;

@Service
public class PurchaseLogServiceImpl implements PurchaseLogService{
	
	@Autowired
	private PurchaseLogRepository purchaseLogRepository;

	@Override
	public PurchaseLog addLog(PurchaseLog purchaseLog) {
		// TODO Auto-generated method stub
		return purchaseLogRepository.save(purchaseLog);
	}

	@Override
	public PurchaseLog getLogByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return purchaseLogRepository.getByUserId(userId);
	}

	@Override
	public PurchaseLog updateInventoryIdByUserId(Integer userId, Integer inventoryId) {
		// TODO Auto-generated method stub
		PurchaseLog purchaseLog = getLogByUserId(userId);
		purchaseLog.setInventoryId(inventoryId);
		return purchaseLogRepository.save(purchaseLog);
	}

	@Override
	public List<PurchaseLog> getAllLogs() {
		// TODO Auto-generated method stub
		return purchaseLogRepository.findAll();
	}

}
