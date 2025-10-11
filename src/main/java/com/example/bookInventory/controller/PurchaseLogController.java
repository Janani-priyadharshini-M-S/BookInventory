

package com.example.bookInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.PurchaseLog;
import com.example.bookInventory.service.PurchaseLogService;

@RestController
@RequestMapping("/api/purchaselog")
public class PurchaseLogController {
	
	@Autowired
	private PurchaseLogService purchaseLogService;
	
	//2
	@GetMapping("{userId}")
	public ResponseEntity<PurchaseLog> getLogByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(purchaseLogService.getLogByUserId(userId));
	}
	
	//1
	@PostMapping("/post")
	public ResponseEntity<String> addLog(@RequestBody PurchaseLog purchaseLog) {
	    purchaseLogService.addLog(purchaseLog);
	    return ResponseEntity.ok("Purchase Log added successfully");
	}
	
	//3
	@PutMapping("/update/inventoryid/{userId}")
	public ResponseEntity<PurchaseLog> updateInventoryId(@PathVariable Integer userId, @RequestBody Integer inventoryId){
		return ResponseEntity.ok(purchaseLogService.updateInventoryIdByUserId(userId, inventoryId));
	}

     @GetMapping()
     public ResponseEntity<List<PurchaseLog>> getAllLogs() {
     return ResponseEntity.ok(purchaseLogService.getAllLogs());
}

	
}


//1 out put message 
