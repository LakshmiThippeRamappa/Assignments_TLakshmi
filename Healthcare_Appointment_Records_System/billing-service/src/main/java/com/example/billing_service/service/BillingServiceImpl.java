package com.example.billing_service.service;

import com.example.billing_service.dto.BillingRequest;
import com.example.billing_service.dto.BillingResponse;
import com.example.billing_service.entity.Billing;
import com.example.billing_service.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository repository;

    @Override
    public BillingResponse createBilling(BillingRequest request) {
        Billing billing = new Billing();
        billing.setPatientId(request.getPatientId());
        billing.setAmount(request.getAmount());
        billing.setStatus(request.getStatus());
        billing.setBillingDate(request.getBillingDate());
        billing.setInsuranceClaimNumber(request.getInsuranceClaimNumber());

        Billing saved = repository.save(billing);

        BillingResponse response = new BillingResponse();
        response.setId(saved.getId());
        response.setPatientId(saved.getPatientId());
        response.setAmount(saved.getAmount());
        response.setStatus(saved.getStatus());
        response.setBillingDate(saved.getBillingDate());
        response.setInsuranceClaimNumber(saved.getInsuranceClaimNumber());
        return response;
    }

    @Override
    public List<BillingResponse> getAllBillings() {
        return repository.findAll().stream().map(b -> {
            BillingResponse r = new BillingResponse();
            r.setId(b.getId());
            r.setPatientId(b.getPatientId());
            r.setAmount(b.getAmount());
            r.setStatus(b.getStatus());
            r.setBillingDate(b.getBillingDate());
            r.setInsuranceClaimNumber(b.getInsuranceClaimNumber());
            return r;
        }).collect(Collectors.toList());
    }

    @Override
    public List<BillingResponse> getBillingsByPatientId(Long patientId) {
        return repository.findByPatientId(patientId).stream().map(b -> {
            BillingResponse r = new BillingResponse();
            r.setId(b.getId());
            r.setPatientId(b.getPatientId());
            r.setAmount(b.getAmount());
            r.setStatus(b.getStatus());
            r.setBillingDate(b.getBillingDate());
            r.setInsuranceClaimNumber(b.getInsuranceClaimNumber());
            return r;
        }).collect(Collectors.toList());
    }
}
