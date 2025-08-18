package com.notification.controller;

import org.springframework.web.bind.annotation.*;

import com.notification.model.Notification;
import com.notification.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService service;
    public NotificationController(NotificationService service) { this.service = service; }

    @GetMapping
    public List<Notification> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Notification get(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Notification create(@RequestBody Notification n) { return service.create(n); }

    @PutMapping("/{id}")
    public Notification update(@PathVariable Long id, @RequestBody Notification updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/user/{userId}")
    public List<Notification> byUser(@PathVariable Long userId) { return service.getByUserId(userId); }

    @PostMapping("/{id}/mark-sent")
    public Notification markSent(@PathVariable Long id) { return service.markSent(id); }
}