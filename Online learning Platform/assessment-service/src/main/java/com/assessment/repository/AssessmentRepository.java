package com.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.model.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    List<Assessment> findByCourseId(Long courseId);
}