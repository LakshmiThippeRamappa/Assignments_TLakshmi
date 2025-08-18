package com.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AssessmentEventProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendAssignmentSubmittedEvent(Long assignmentId, Long studentId) {
        String message = "Assignment Submitted: assignmentId=" + assignmentId + ", studentId=" + studentId;
        kafkaTemplate.send("assignment-submitted-topic", message);
        System.out.println("✅ Sent event: " + message);
    }
}