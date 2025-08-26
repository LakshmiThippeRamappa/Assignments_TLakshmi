import { ChangeDetectorRef, Component } from '@angular/core';
import { Course } from '../../model/course.model';
import { CourseService } from '../../service/course.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-courses',
  imports: [CommonModule,RouterLink],
  templateUrl: './view-courses.html',
  styleUrl: './view-courses.css'
})
export class ViewCourses {

  courses: Course[] = [];

  constructor(private courseService: CourseService, private router: Router,private cdr:ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses() {
  this.courseService.getAllCourses().subscribe({
    next: (data) => {
      console.log(" Courses loaded from backend:", data);
      this.courses = data;
      this.cdr.detectChanges();
    },
    error: (err) => {
      console.error("Error while loading courses:", err);
      this.cdr.detectChanges();
    },
    complete: () => {
      console.log("Finished loading courses.");
    }
  });
}


  deleteCourse(id: number) {
    this.router.navigate(['/delete-course', id]);
  }

  editCourse(id: number) {
    this.router.navigate(['/edit-course', id]);
  }

  viewDetails(id: number) {
    this.router.navigate(['/course-details', id]);
  }

}
