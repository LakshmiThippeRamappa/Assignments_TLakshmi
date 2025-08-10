package com.ecommerce.service.impl;

import com.ecommerce.model.Order;
import com.ecommerce.service.CartValidator;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CartValidator cartValidator;

    @Override
    public String checkout(String cartId) {
        if (!cartValidator.validateCart(cartId)) {
            return "Cart is invalid";
        }

        // Simulate cart with item IDs
        List<String> items = Arrays.asList("ITEM100", "ITEM101"); // pretend these came from the cart
        Order order = new Order(cartId, items);

        for (String itemId : order.getItemIds()) {
            if (!inventoryService.isAvailable(itemId)) {
                return "Item out of stock";
            }
        }

        return "Checkout successful for " + cartId;
    }
}
