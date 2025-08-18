package com.assessment.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.assessment.dto.NotificationRequest;

@FeignClient(name = "notification-service", url = "http://localhost:5005/api/notifications")
public interface NotificationClient {

    @PostMapping
    NotificationRequest sendNotification(NotificationRequest request);
}