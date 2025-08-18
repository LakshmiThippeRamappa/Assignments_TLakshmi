package com.classroom.controller;

import org.springframework.web.bind.annotation.*;

import com.classroom.model.Attendance;
import com.classroom.service.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    private final AttendanceService attendanceService;
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<Attendance> getAll() { return attendanceService.getAll(); }

    @GetMapping("/{id}")
    public Attendance get(@PathVariable Long id) { return attendanceService.getById(id); }

    @PostMapping
    public Attendance mark(@RequestBody Attendance a) { return attendanceService.markAttendance(a); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { attendanceService.delete(id); }

    @GetMapping("/classroom/{classroomId}")
    public List<Attendance> getByClassroom(@PathVariable Long classroomId) {
        return attendanceService.getByClassroomId(classroomId);
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getByStudent(@PathVariable Long studentId) {
        return attendanceService.getByStudentId(studentId);
    }
}
