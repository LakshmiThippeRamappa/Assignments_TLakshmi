package com.classroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classroom.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findByCourseId(Long courseId);
}