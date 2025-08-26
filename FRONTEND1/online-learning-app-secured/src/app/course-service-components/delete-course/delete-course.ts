import { ChangeDetectorRef, Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../../service/course.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-delete-course',
  imports: [CommonModule,FormsModule],
  templateUrl: './delete-course.html',
  styleUrl: './delete-course.css'
})
export class DeleteCourse {

  courseId!: number;
  message:string = '';
  confirmDelete = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private courseService: CourseService,
    private cdr:ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.courseId = +this.route.snapshot.paramMap.get('id')!;
  }

  askConfirmation() {
    this.confirmDelete = true;
  }

  deleteCourse() {
    this.courseService.deleteCourse(this.courseId).subscribe({
      next: () => {
        this.message = `Course with ID ${this.courseId} deleted successfully.`;
        setTimeout(() => this.router.navigate(['/view-courses']), 1500);
        this.cdr.detectChanges();
      },
      error: () => {
        this.message = `Error: Could not delete course with ID ${this.courseId}`;
        this.cdr.detectChanges();
      }
    });
  }

  cancel() {
    this.router.navigate(['/view-courses']);
  }

}
