package com.example.billing_service.service;

import com.example.billing_service.dto.BillingRequest;
import com.example.billing_service.dto.BillingResponse;

import java.util.List;

public interface BillingService {
    BillingResponse createBilling(BillingRequest request);
    List<BillingResponse> getAllBillings();
    List<BillingResponse> getBillingsByPatientId(Long patientId);
}
