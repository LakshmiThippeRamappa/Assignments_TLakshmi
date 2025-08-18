package com.example.appointment_service.service;

import com.example.appointment_service.dto.AppointmentRequest;
import com.example.appointment_service.dto.AppointmentResponse;
import com.example.appointment_service.dto.RescheduleRequest;

import java.util.List;

public interface AppointmentService {
    AppointmentResponse book(AppointmentRequest request);
    AppointmentResponse reschedule(Long id, RescheduleRequest request);
    void cancel(Long id);
    AppointmentResponse get(Long id);
    List<AppointmentResponse> listByDoctor(Long doctorId);
    List<AppointmentResponse> listByPatient(Long patientId);
    List<AppointmentResponse> listAll();

}
