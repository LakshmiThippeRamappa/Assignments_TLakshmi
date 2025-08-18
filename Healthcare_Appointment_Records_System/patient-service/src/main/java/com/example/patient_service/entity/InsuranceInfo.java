package com.example.patient_service.entity;

import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class InsuranceInfo {

    private String provider;
    private String policyNumber;
    private LocalDate validTill;

    public InsuranceInfo() { }

    public InsuranceInfo(String provider, String policyNumber, LocalDate validTill) {
        this.provider = provider;
        this.policyNumber = policyNumber;
        this.validTill = validTill;
    }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public LocalDate getValidTill() { return validTill; }
    public void setValidTill(LocalDate validTill) { this.validTill = validTill; }
}
