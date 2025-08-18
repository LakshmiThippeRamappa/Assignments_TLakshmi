package com.notification.repository;

import com.notification.model.Notification;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
    List<Notification> findBySentFalseAndScheduledAtBefore(LocalDateTime time);
}