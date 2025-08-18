package com.assessment.dto;

import java.time.LocalDateTime;

public class NotificationRequest {
    private Long userId;
    private String message;
    private String type;
    private LocalDateTime scheduledAt;
    private boolean sent;
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