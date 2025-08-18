package com.notification.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notifications") // MongoDB collection name
public class Notification {

    @Id
    private String id; // MongoDB IDs are usually String (ObjectId), not Long

    private Long userId;       // recipient (from User service)
    private String message;
    private String type;       // EMAIL, SMS, PUSH, REMINDER, GRADE, etc.
    private LocalDateTime scheduledAt;
    private boolean sent;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }
    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }
    public boolean isSent() {
        return sent;
    }
    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
