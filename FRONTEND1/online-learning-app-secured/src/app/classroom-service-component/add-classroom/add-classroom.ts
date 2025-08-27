import { ChangeDetectorRef, Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Classroom } from '../../model/classroom-models/classroom.model';
import { ClassroomService } from '../../service/classroom-service/classroom.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-classroom',
  imports: [FormsModule,RouterLink,CommonModule],
  templateUrl: './add-classroom.html',
  styleUrl: './add-classroom.css'
})
export class AddClassroom {

   classroom: Classroom = {
    courseId: 0,
    sessionDateTime: '',
    sessionLink: ''
  };

  message: string = '';

  constructor(
    private classroomService: ClassroomService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  addClassroom(): void {
    console.log('Attempting to add classroom:', this.classroom);

    this.classroomService.createClassroom(this.classroom).subscribe({
      next: (res) => {
        console.log('Classroom created successfully:', res);
        this.message = 'Classroom added successfully!';
        this.cdr.detectChanges();

        // Redirect after short delay (optional UX improvement)
        setTimeout(() => {
          this.router.navigate(['/view-classrooms']);
        }, 1000);
      },
      error: (err) => {
        console.error('Error creating classroom:', err);
        this.message = ' Failed to add classroom. Please try again.';
        this.cdr.detectChanges();
      }
    });
  }

}
