package com.example.appointment_service.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class RescheduleRequest {

    @NotNull
    @Future(message = "Start time must be in the future")
    private LocalDateTime newStartTime;

    @NotNull
    @Future(message = "End time must be in the future")
    private LocalDateTime newEndTime;

    public RescheduleRequest() {}

    public LocalDateTime getNewStartTime() { return newStartTime; }
    public void setNewStartTime(LocalDateTime newStartTime) { this.newStartTime = newStartTime; }

    public LocalDateTime getNewEndTime() { return newEndTime; }
    public void setNewEndTime(LocalDateTime newEndTime) { this.newEndTime = newEndTime; }
}
