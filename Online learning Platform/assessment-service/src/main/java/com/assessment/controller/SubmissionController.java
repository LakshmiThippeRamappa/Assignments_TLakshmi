package com.assessment.controller;

import org.springframework.web.bind.annotation.*;

import com.assessment.model.Submission;
import com.assessment.service.SubmissionService;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    private final SubmissionService submissionService;
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public List<Submission> getAll() { return submissionService.getAll(); }

    @GetMapping("/{id}")
    public Submission get(@PathVariable Long id) { return submissionService.getById(id); }

    @PostMapping
    public Submission submit(@RequestBody Submission s) { return submissionService.submit(s); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { submissionService.delete(id); }

    @GetMapping("/assessment/{assessmentId}")
    public List<Submission> getByAssessment(@PathVariable Long assessmentId) {
        return submissionService.getByAssessmentId(assessmentId);
    }

    @GetMapping("/student/{studentId}")
    public List<Submission> getByStudent(@PathVariable Long studentId) {
        return submissionService.getByStudentId(studentId);
    }

    @PostMapping("/{id}/grade")
    public Submission grade(@PathVariable Long id, @RequestParam Integer marks, @RequestParam(required = false) String feedback) {
        return submissionService.gradeSubmission(id, marks, feedback);
    }
}