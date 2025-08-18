package com.example.appointment_service.repository;

import com.example.appointment_service.entity.Appointment;
import com.example.appointment_service.entity.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Overlap check for a doctor's schedule:
    // there is an overlap if (existing.start < newEnd) and (existing.end > newStart)
    boolean existsByDoctorIdAndStatusInAndStartTimeLessThanAndEndTimeGreaterThan(
            Long doctorId,
            Collection<AppointmentStatus> statuses,
            LocalDateTime newEnd,
            LocalDateTime newStart
    );

    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByPatientId(Long patientId);
}
