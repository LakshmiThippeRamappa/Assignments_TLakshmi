package com.ecommerce.service.impl;

import com.ecommerce.service.CartValidator;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CartValidatorImpl implements CartValidator {
    private Set<String> validCarts = new HashSet<>();

    public CartValidatorImpl() {
        validCarts.add("CART001");
        validCarts.add("CART002");
    }

    @Override
    public boolean validateCart(String cartId) {
        return validCarts.contains(cartId);
    }
}
