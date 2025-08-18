package com.classroom.service;

import org.springframework.stereotype.Service;

import com.classroom.model.Classroom;
import com.classroom.repository.ClassroomRepository;

import java.util.List;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getAll() { return classroomRepository.findAll(); }
    public Classroom getById(Long id) { return classroomRepository.findById(id).orElse(null); }
    public Classroom create(Classroom c) { return classroomRepository.save(c); }
    public Classroom update(Long id, Classroom updated) {
        return classroomRepository.findById(id).map(existing -> {
            existing.setCourseId(updated.getCourseId());
            existing.setTeacherId(updated.getTeacherId());
            existing.setStartTime(updated.getStartTime());
            existing.setEndTime(updated.getEndTime());
            existing.setAttendeeIdsCsv(updated.getAttendeeIdsCsv());
            existing.setActive(updated.isActive());
            return classroomRepository.save(existing);
        }).orElse(null);
    }
    public void delete(Long id) { classroomRepository.deleteById(id); }

    public List<Classroom> getByCourseId(Long courseId) {
        return classroomRepository.findByCourseId(courseId);
    }
}
