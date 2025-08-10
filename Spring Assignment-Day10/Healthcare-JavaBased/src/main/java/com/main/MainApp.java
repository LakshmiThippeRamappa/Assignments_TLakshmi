package com.main;

import com.config.AppConfig;
import com.service.AppointmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppointmentService appointmentService = context.getBean(AppointmentService.class);

        System.out.println(appointmentService.book("DOC101", "2025-04-10")); // Appointment confirmed
        System.out.println(appointmentService.book("DOC101", "2025-04-12")); // Doctor not available
    }
}
