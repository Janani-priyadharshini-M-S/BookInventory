package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.PurchaseLog;
import com.example.bookInventory.service.PurchaseLogService;

public class PurchaseLogServiceTest {

    PurchaseLogService purchaseLogService = mock(PurchaseLogService.class);

    @Test
    void testAddPurchaseLog() {
        PurchaseLog purchaseLog = new PurchaseLog(1, 101);
        when(purchaseLogService.addLog(purchaseLog)).thenReturn(purchaseLog);

        PurchaseLog result = purchaseLogService.addLog(purchaseLog);
        assertEquals(101, result.getInventoryId());
    }

    @Test
    void testGetLogByUserId() {
        PurchaseLog purchaseLog = new PurchaseLog(1, 101);
        when(purchaseLogService.getLogByUserId(1)).thenReturn(purchaseLog);

        PurchaseLog result = purchaseLogService.getLogByUserId(1);
        assertEquals(101, result.getInventoryId());
    }

    @Test
    void testUpdateInventoryIdByUserId() {
        PurchaseLog updatedLog = new PurchaseLog(1, 202);
        when(purchaseLogService.updateInventoryIdByUserId(1, 202)).thenReturn(updatedLog);

        PurchaseLog result = purchaseLogService.updateInventoryIdByUserId(1, 202);
        assertEquals(202, result.getInventoryId());
    }

    @Test
    void testGetAllLogs() {
        PurchaseLog log1 = new PurchaseLog(1, 101);
        PurchaseLog log2 = new PurchaseLog(2, 102);
        List<PurchaseLog> logs = Arrays.asList(log1, log2);

        when(purchaseLogService.getAllLogs()).thenReturn(logs);

        List<PurchaseLog> result = purchaseLogService.getAllLogs();
        assertEquals(2, result.size());
        assertEquals(102, result.get(1).getInventoryId());
    }
}