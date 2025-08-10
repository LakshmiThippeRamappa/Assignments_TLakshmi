package com.ecommerce.service.impl;

import com.ecommerce.service.InventoryService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InventoryServiceImpl implements InventoryService {
    private Set<String> inStockItems = new HashSet<>();

    public InventoryServiceImpl() {
        inStockItems.add("ITEM100");
        inStockItems.add("ITEM101");
        inStockItems.add("ITEM102");
    }

    @Override
    public boolean isAvailable(String itemId) {
        return inStockItems.contains(itemId);
    }
}
