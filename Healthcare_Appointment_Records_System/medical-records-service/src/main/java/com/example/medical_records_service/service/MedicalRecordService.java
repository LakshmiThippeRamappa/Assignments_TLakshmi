package com.example.medical_records_service.service;

import com.example.medical_records_service.dto.MedicalRecordRequest;
import com.example.medical_records_service.dto.MedicalRecordResponse;
import com.example.medical_records_service.model.MedicalRecord;
import com.example.medical_records_service.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository repository;

    public List<MedicalRecordResponse> getAllRecords() {
        return repository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<MedicalRecordResponse> getRecordsByPatientId(Long patientId) {
        return repository.findByPatientId(patientId).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public MedicalRecordResponse createRecord(MedicalRecordRequest request) {
        MedicalRecord record = new MedicalRecord();
        record.setPatientId(request.getPatientId());
        record.setVisitDate(request.getVisitDate());
        record.setDiagnosis(request.getDiagnosis());
        record.setPrescription(request.getPrescription());
        record.setTestResults(request.getTestResults());

        MedicalRecord saved = repository.save(record);
        return mapToResponse(saved);
    }

    private MedicalRecordResponse mapToResponse(MedicalRecord record) {
        MedicalRecordResponse response = new MedicalRecordResponse();
        response.setId(record.getId());
        response.setPatientId(record.getPatientId());
        response.setVisitDate(record.getVisitDate());
        response.setDiagnosis(record.getDiagnosis());
        response.setPrescription(record.getPrescription());
        response.setTestResults(record.getTestResults());
        return response;
    }
}
