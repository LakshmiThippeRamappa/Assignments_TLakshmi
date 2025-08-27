import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Classroom } from '../../model/classroom-models/classroom.model';
import { ClassroomService } from '../../service/classroom-service/classroom.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-classroom',
  imports: [RouterLink,FormsModule,CommonModule],
  templateUrl: './edit-classroom.html',
  styleUrl: './edit-classroom.css'
})
export class EditClassroom implements OnInit{

  classroom: Classroom = { courseId: 0, sessionDateTime: '', sessionLink: '' };
  message: string = '';
  loading: boolean = false;
   messageType: 'success' | 'error' | '' = ''; // ✅ track type of message

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private classroomService: ClassroomService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    console.log('Fetching classroom with ID:', id);

    this.loading = true;
    this.classroomService.getClassroomById(id).subscribe({
      next: (data) => {
        this.classroom = data;
        // this.message = 'Classroom details loaded successfully.';
        console.log('Classroom data received:', data);
        this.loading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.messageType = 'error';
        this.message = 'Error loading classroom details. Please try again.';
        console.error('Error fetching classroom:', err);
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }

  updateClassroom(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    console.log('Updating classroom with ID:', id, 'Data:', this.classroom);

    this.loading = true;
    this.classroomService.updateClassroom(id, this.classroom).subscribe({
      next: () => {
        this.messageType = 'success';
        this.message = 'Classroom updated successfully!';
        console.log('Classroom updated successfully.');
        this.loading = false;
        this.cdr.detectChanges();
        setTimeout(()=>{
            this.router.navigate(['/view-classrooms']);
        },1500
        )
      },
      error: (err) => {
        this.messageType = 'error';
        this.message =  err.error?.message ||'Error updating classroom. Please try again.';
        console.error('Error updating classroom:', err);
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }
}