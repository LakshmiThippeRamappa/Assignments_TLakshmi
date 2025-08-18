package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.model.Submission;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByAssessmentId(Long assessmentId);
    List<Submission> findByStudentId(Long studentId);
}