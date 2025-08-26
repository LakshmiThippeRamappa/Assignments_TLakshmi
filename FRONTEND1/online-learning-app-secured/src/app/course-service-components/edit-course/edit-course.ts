import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Course } from '../../model/course.model';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CourseService } from '../../service/course.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-course',
  imports: [FormsModule,CommonModule,RouterLink],
  templateUrl: './edit-course.html',
  styleUrl: './edit-course.css'
})
export class EditCourse implements OnInit{

   course: Course = { title: '', description: '', teacherId: 0 };
  id!: number;

  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService,
    private router: Router,
    private cdr:ChangeDetectorRef
  ) {}

  message: string = "";   // feedback message

ngOnInit(): void {
  this.id = Number(this.route.snapshot.paramMap.get('id'));

  this.courseService.getCourseWithStudents(this.id).subscribe({
    next: (data) => {
      this.course = {
        id: data.id,
        title: data.title,
        description: data.description,
        teacherId: data.teacher.id
      };
      console.log("📌 Loaded course for edit:", this.course);
      this.cdr.detectChanges();
    },
    error: (err) => {
      this.message = "❌ Failed to load course details.";
      console.error("Error while fetching course:", err);
    }
  });
}

updateCourse(): void {
  this.courseService.updateCourse(this.id, this.course).subscribe({
    next: () => {
      this.message = "Course updated successfully!";
      console.log("Course updated successfully:", this.course);

      // redirect after short delay so user sees the message
      setTimeout(() => {
        this.router.navigate(['/view-courses']);
      }, 1500);

      this.cdr.detectChanges();
    },
    error: (err) => {
      this.message = "Failed to update course. Please try again.";
      console.error("Error while updating course:", err);
    }
  });
}


}
