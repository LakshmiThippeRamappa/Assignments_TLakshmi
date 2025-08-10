package com.ecommerce.model;

import java.util.List;

public class Order {
    private String orderId;
    private List<String> itemIds;

    public Order(String orderId, List<String> itemIds) {
        this.orderId = orderId;
        this.itemIds = itemIds;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<String> getItemIds() {
        return itemIds;
    }
}
