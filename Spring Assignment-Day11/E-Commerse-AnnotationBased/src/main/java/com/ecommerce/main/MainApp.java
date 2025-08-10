package com.ecommerce.main;

import com.ecommerce.config.AppConfig;
import com.ecommerce.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        System.out.println(orderService.checkout("CART001")); // Checkout successful
        System.out.println(orderService.checkout("CART999")); // Cart is invalid
    }
}
