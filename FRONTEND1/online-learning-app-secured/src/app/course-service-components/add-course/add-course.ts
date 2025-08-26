import { ChangeDetectorRef, Component } from '@angular/core';
import { Course } from '../../model/course.model';
import { CourseService } from '../../service/course.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-course',
  imports: [CommonModule,FormsModule],
  templateUrl: './add-course.html',
  styleUrl: './add-course.css'
})
export class AddCourse {

   course: Course = { title: '', description: '', teacherId: 0 };

message:string='';

  constructor(private courseService: CourseService, private router: Router,private cdr:ChangeDetectorRef) {}

  saveCourse() {
  this.courseService.createCourse(this.course).subscribe({
    next: () => {
      this.message = " Course saved successfully!";
      console.log("Course created:", this.course);

      // redirect after short delay so user sees the message
      setTimeout(() => {
        this.router.navigate(['/view-courses']);
      }, 1500);
      this.cdr.detectChanges();
    },
    error: (err) => {
      this.message = "Failed to save course. Please try again.";
      console.error("Error while saving course:", err);
      this.cdr.detectChanges();
    }
  });
}


}
