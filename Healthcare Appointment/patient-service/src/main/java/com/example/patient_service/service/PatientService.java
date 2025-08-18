package com.example.patient_service.service;

import com.example.patient_service.dto.PatientRequest;
import com.example.patient_service.dto.PatientResponse;

import java.util.List;

public interface PatientService {
    PatientResponse create(PatientRequest request);
    PatientResponse update(Long id, PatientRequest request);
    PatientResponse get(Long id);
    List<PatientResponse> list(String q);
    void delete(Long id);
}
