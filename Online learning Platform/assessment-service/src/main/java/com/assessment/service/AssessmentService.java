package com.assessment.service;

import org.springframework.stereotype.Service;

import com.assessment.dto.NotificationRequest;
import com.assessment.feign.NotificationClient;
import com.assessment.model.Assessment;
import com.assessment.repository.AssessmentRepository;

import java.util.List;

@Service
public class AssessmentService {
	private final AssessmentRepository assessmentRepository;

	private final NotificationClient notificationClient;

    public AssessmentService(AssessmentRepository assessmentRepository, NotificationClient notificationClient) {
        this.assessmentRepository = assessmentRepository;
        this.notificationClient = notificationClient;
    }

    public Assessment create(Assessment a) {
        Assessment saved = assessmentRepository.save(a);

        // Trigger notification for due date
        NotificationRequest req = new NotificationRequest();
        req.setUserId(201L); // could be from enrolled student IDs
        req.setMessage("Assessment '" + saved.getTitle() + "' is due on " + saved.getDueDate());
        req.setType("REMINDER");
        req.setScheduledAt(saved.getDueDate().minusDays(1)); // reminder 1 day before
        req.setSent(false);

        notificationClient.sendNotification(req);

        return saved;
    }

	

	public Assessment getById(Long id) {
		return assessmentRepository.findById(id).orElse(null);
	}

	public List<Assessment> getAll() {
		return assessmentRepository.findAll();
	}

	public Assessment update(Long id, Assessment updated) {
		return assessmentRepository.findById(id).map(existing -> {
			existing.setTitle(updated.getTitle());
			existing.setType(updated.getType());
			existing.setQuestionsJson(updated.getQuestionsJson());
			existing.setDueDate(updated.getDueDate());
			existing.setMaxMarks(updated.getMaxMarks());
			existing.setCourseId(updated.getCourseId());
			return assessmentRepository.save(existing);
		}).orElse(null);
	}

	public void delete(Long id) {
		assessmentRepository.deleteById(id);
	}

	public List<Assessment> getByCourseId(Long courseId) {
		return assessmentRepository.findByCourseId(courseId);
	}
}