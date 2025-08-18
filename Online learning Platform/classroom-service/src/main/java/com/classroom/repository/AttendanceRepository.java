package com.classroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classroom.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByClassroomId(Long classroomId);
    List<Attendance> findByStudentId(Long studentId);
}