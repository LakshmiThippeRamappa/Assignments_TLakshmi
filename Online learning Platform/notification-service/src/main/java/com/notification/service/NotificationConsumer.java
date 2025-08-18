package com.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "class-created-topic", groupId = "online-learning-group")
    public void handleClassCreated(String message) {
        System.out.println("📩 Notification Service received: " + message);
        // TODO: save notification in DB or send email
    }

    @KafkaListener(topics = "assignment-submitted-topic", groupId = "online-learning-group")
    public void handleAssignmentSubmitted(String message) {
        System.out.println("📩 Notification Service received: " + message);
        // TODO: notify teacher/student
    }
}