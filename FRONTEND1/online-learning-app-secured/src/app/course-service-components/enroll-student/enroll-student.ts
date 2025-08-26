import { ChangeDetectorRef, Component } from '@angular/core';
import { CourseService } from '../../service/course.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-enroll-student',
  imports: [FormsModule,CommonModule],
  templateUrl: './enroll-student.html',
  styleUrl: './enroll-student.css'
})
export class EnrollStudent {

  courseId!: number;
  studentId!: number;
  message = '';

  constructor( private route: ActivatedRoute,private courseService: CourseService,private cdr:ChangeDetectorRef) {}

ngOnInit(): void {
  this.courseId = +this.route.snapshot.paramMap.get('courseId')!;
  console.log(`Loaded Course ID: ${this.courseId}`);
}

enroll(): void {
  console.log(`🔄 Enrolling student with ID: ${this.studentId} in course: ${this.courseId}`);

  this.courseService.enrollStudent(this.courseId, this.studentId).subscribe({
    next: () => {
      this.message = `Student ${this.studentId} successfully enrolled in course ${this.courseId}`;
      console.log(this.message);
      this.cdr.detectChanges();
    },
    error: (err) => {
  // Try to read backend message
  if (err.error && err.error.message) {
    this.message = `${err.error.message}`;
  } else {
    this.message = `Failed to enroll student ${this.studentId} in course ${this.courseId}`;
  }

  console.error("Enrollment error:", err);
  this.cdr.detectChanges();
  }
  });
}


}
