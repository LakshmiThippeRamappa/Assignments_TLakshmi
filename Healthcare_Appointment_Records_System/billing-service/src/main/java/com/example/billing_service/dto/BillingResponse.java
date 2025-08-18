package com.example.billing_service.dto;

import java.time.LocalDate;

public class BillingResponse {
    private Long id;
    private Long patientId;
    private Double amount;
    private String status;
    private LocalDate billingDate;
    private String insuranceClaimNumber;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getBillingDate() { return billingDate; }
    public void setBillingDate(LocalDate billingDate) { this.billingDate = billingDate; }
    public String getInsuranceClaimNumber() { return insuranceClaimNumber; }
    public void setInsuranceClaimNumber(String insuranceClaimNumber) { this.insuranceClaimNumber = insuranceClaimNumber; }
}
