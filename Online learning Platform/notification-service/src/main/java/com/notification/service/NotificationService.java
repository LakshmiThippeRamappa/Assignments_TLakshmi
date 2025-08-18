package com.notification.service;

import org.springframework.stereotype.Service;

import com.notification.model.Notification;
import com.notification.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository repo;
    public NotificationService(NotificationRepository repo) { this.repo = repo; }

    public Notification create(Notification n) { return repo.save(n); }
    public Notification getById(Long id) { return repo.findById(id).orElse(null); }
    public List<Notification> getAll() { return repo.findAll(); }
    public Notification update(Long id, Notification updated) {
        return repo.findById(id).map(existing -> {
            existing.setUserId(updated.getUserId());
            existing.setMessage(updated.getMessage());
            existing.setType(updated.getType());
            existing.setScheduledAt(updated.getScheduledAt());
            existing.setSent(updated.isSent());
            return repo.save(existing);
        }).orElse(null);
    }
    public void delete(Long id) { repo.deleteById(id); }
    public List<Notification> getByUserId(Long userId) { return repo.findByUserId(userId); }

    // Find pending notifications to be processed by a scheduler (example helper)
    public List<Notification> findPendingToSend() {
        return repo.findBySentFalseAndScheduledAtBefore(LocalDateTime.now());
    }

    // mark sent
    public Notification markSent(Long id) {
        return repo.findById(id).map(n -> {
            n.setSent(true);
            return repo.save(n);
        }).orElse(null);
    }
}
