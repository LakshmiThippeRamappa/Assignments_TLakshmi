package com.example.billing_service.controller;

import com.example.billing_service.dto.BillingRequest;
import com.example.billing_service.dto.BillingResponse;
import com.example.billing_service.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    @Autowired
    private BillingService service;

    @PostMapping
    public ResponseEntity<BillingResponse> createBilling(@RequestBody BillingRequest request) {
        return ResponseEntity.ok(service.createBilling(request));
    }

    @GetMapping
    public ResponseEntity<List<BillingResponse>> getAllBillings() {
        return ResponseEntity.ok(service.getAllBillings());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<BillingResponse>> getBillingsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.getBillingsByPatientId(patientId));
    }
}
