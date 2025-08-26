import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CourseService } from '../../service/course.service';
import { CourseResponse } from '../../model/course-response.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-course-details',
  imports: [CommonModule,RouterLink,FormsModule],
  templateUrl: './course-details.html',
  styleUrls:[ './course-details.css']
})
export class CourseDetails implements OnInit{

 course!: CourseResponse;
  studentId!: number;   // ✅ new field for input
  message:string = '';         // ✅ success/error message

  constructor(
    private route: ActivatedRoute, 
    private courseService: CourseService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.loadCourse(id);
  }

  loadCourse(id: number) {
    this.courseService.getCourseWithStudents(id).subscribe({
      next: (data) => {
        this.course = data;
        console.log("Loaded course details:", this.course);
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error("Failed to load course details:", err);
        this.cdr.detectChanges();
      }
    });
  }

  // ✅ Enroll new student
  enrollStudent() {
    if (!this.studentId) return;

    this.courseService.enrollStudent(this.course.id!, this.studentId).subscribe({
      next: () => {
        this.message = `Student ${this.studentId} enrolled successfully!`;
        if (this.course?.id !== undefined) {
      this.loadCourse(this.course.id);  //refresh list of students
      this.cdr.detectChanges();
      }

      },
      error: (err) => {
        console.error("Error enrolling student:", err);
        this.message = `Failed to enroll student with ID ${this.studentId}`;
        this.cdr.detectChanges();
      }
    });
  }

}
