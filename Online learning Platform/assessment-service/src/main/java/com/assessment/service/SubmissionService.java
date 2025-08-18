package com.assessment.service;

import org.springframework.stereotype.Service;

import com.assessment.model.Submission;
import com.assessment.repository.SubmissionRepository;

import java.util.List;

@Service
public class SubmissionService {
    private final SubmissionRepository submissionRepository;
    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public Submission submit(Submission s) { return submissionRepository.save(s); }
    public Submission getById(Long id) { return submissionRepository.findById(id).orElse(null); }
    public List<Submission> getAll() { return submissionRepository.findAll(); }
    public void delete(Long id) { submissionRepository.deleteById(id); }
    public List<Submission> getByAssessmentId(Long assessmentId) { return submissionRepository.findByAssessmentId(assessmentId); }
    public List<Submission> getByStudentId(Long studentId) { return submissionRepository.findByStudentId(studentId); }

    // Simple auto-grade example (could be expanded): set marks and feedback
    public Submission gradeSubmission(Long submissionId, Integer marks, String feedback) {
        return submissionRepository.findById(submissionId).map(s -> {
            s.setMarksObtained(marks);
            s.setFeedback(feedback);
            return submissionRepository.save(s);
        }).orElse(null);
    }
}
