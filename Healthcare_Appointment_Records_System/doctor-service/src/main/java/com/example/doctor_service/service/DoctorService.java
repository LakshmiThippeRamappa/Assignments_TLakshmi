package com.example.doctor_service.service;

import com.example.doctor_service.entity.Doctor;
import com.example.doctor_service.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id).map(existingDoctor -> {
            existingDoctor.setFirstName(updatedDoctor.getFirstName());
            existingDoctor.setLastName(updatedDoctor.getLastName());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setPhone(updatedDoctor.getPhone());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            return doctorRepository.save(existingDoctor);
        }).orElse(null);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
