package com.config;

import com.repository.DoctorRepository;
import com.service.AppointmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DoctorRepository doctorRepository() {
        return new DoctorRepository();
    }

    @Bean
    public AppointmentService appointmentService() {
        return new AppointmentService(doctorRepository());
    }
}
