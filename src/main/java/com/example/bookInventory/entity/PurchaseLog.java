package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="purchaseLog")
public class PurchaseLog {
	@Id
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="inventoryId")
	private Integer inventoryId;

	public PurchaseLog() {
		super();
	}

	public PurchaseLog(Integer userId, Integer inventoryId) {
		super();
		this.userId = userId;
		this.inventoryId = inventoryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@Override
	public String toString() {
		return "PurchaseLog [userId=" + userId + ", inventoryId=" + inventoryId + "]";
	}
	
	
}