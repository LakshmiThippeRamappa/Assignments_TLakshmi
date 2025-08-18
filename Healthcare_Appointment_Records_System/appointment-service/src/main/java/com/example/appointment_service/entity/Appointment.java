package com.example.appointment_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments",
       indexes = {
           @Index(name = "idx_appt_doctor_time", columnList = "doctorId,startTime,endTime"),
           @Index(name = "idx_appt_patient", columnList = "patientId")
       })
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Reference IDs to other services (no FK to keep microservices decoupled) */
    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull
    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;

    @NotNull
    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status = AppointmentStatus.CONFIRMED;

    @Size(max = 200)
    private String reason;

    public Appointment() {}

    public Appointment(Long patientId, Long doctorId,
                       LocalDateTime startTime, LocalDateTime endTime,
                       AppointmentStatus status, String reason) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.reason = reason;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public AppointmentStatus getStatus() { return status; }
    public void setStatus(AppointmentStatus status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
