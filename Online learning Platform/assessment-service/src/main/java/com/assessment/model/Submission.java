package com.assessment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assessmentId;
    private Long studentId;
    private String answerBlob; // student's answers or link
    private Integer marksObtained;
    private String feedback;
    private LocalDateTime submittedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getAnswerBlob() {
		return answerBlob;
	}
	public void setAnswerBlob(String answerBlob) {
		this.answerBlob = answerBlob;
	}
	public Integer getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}
	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}
}