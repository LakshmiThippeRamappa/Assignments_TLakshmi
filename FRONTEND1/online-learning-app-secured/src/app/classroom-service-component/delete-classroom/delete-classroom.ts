import { ChangeDetectorRef, Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClassroomService } from '../../service/classroom-service/classroom.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-delete-classroom',
  imports: [CommonModule],
  templateUrl: './delete-classroom.html',
  styleUrl: './delete-classroom.css'
})
export class DeleteClassroom {

  classroomId!: number;
  message: string = '';
  loading: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private classroomService: ClassroomService,
    private cdr:ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.classroomId = Number(this.route.snapshot.paramMap.get('id'));
    console.log('Preparing to delete classroom with ID:', this.classroomId);
  }

  confirmDelete(): void {
    this.loading = true;
    this.classroomService.deleteClassroom(this.classroomId).subscribe({
      next: () => {
        this.message = 'Classroom deleted successfully!';
        console.log('Classroom deleted successfully.');
        this.loading = false;
        setTimeout(() => {
          this.router.navigate(['/view-classrooms']);
        }, 1500);
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.message = err.error?.message || 'Error deleting classroom. Please try again.';
        console.error('Error deleting classroom:', err);
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }

  cancel(): void {
    this.router.navigate(['/view-classrooms']);
  }

}
