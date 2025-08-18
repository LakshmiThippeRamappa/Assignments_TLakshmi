package com.example.medical_records_service.controller;


import com.example.medical_records_service.dto.MedicalRecordRequest;
import com.example.medical_records_service.dto.MedicalRecordResponse;
import com.example.medical_records_service.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping
    public ResponseEntity<List<MedicalRecordResponse>> getAll() {
        return ResponseEntity.ok(service.getAllRecords());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecordResponse>> getByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.getRecordsByPatientId(patientId));
    }

    @PostMapping
    public ResponseEntity<MedicalRecordResponse> create(@RequestBody MedicalRecordRequest request) {
        return ResponseEntity.ok(service.createRecord(request));
    }
}
