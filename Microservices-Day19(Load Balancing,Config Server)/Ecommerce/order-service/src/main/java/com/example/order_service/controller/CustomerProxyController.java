package com.example.order_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.order_service.dto.CustomerDTO;

@RestController
@RequestMapping("/api/customers")
public class CustomerProxyController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
    public ResponseEntity<CustomerDTO[]> getAllCustomers() {
        CustomerDTO[] customers = restTemplate.getForObject(
                "http://customer-service/api/customers",
                CustomerDTO[].class);
        return ResponseEntity.ok(customers);
    }
   
}
