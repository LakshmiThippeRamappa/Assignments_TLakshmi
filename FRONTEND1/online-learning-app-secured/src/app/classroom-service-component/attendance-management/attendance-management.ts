import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AttendanceResponse } from '../../model/classroom-models/attendance-response.model';
import { ClassroomService } from '../../service/classroom-service/classroom.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-attendance-management',
  imports: [FormsModule,CommonModule],
  templateUrl: './attendance-management.html',
  styleUrl: './attendance-management.css'
})
export class AttendanceManagement implements OnInit{

  classroomId!: number;
  attendanceList: AttendanceResponse[] = [];
  studentId: number = 0;

  successMessage: string = '';
  errorMessage: string = '';


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private classroomService: ClassroomService,
    private cdr:ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.classroomId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadAttendance();
  }

  loadAttendance(): void {
    this.classroomService.getAttendanceDetails(this.classroomId).subscribe({
      next: (data) => {
        this.attendanceList = data;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = err.error?.message || 'Failed to load attendance.';
        this.autoClearMessages();
        this.cdr.detectChanges();
      }
    });
  }

  markAttendance(): void {
    // Validate Student ID
    if (!this.studentId || this.studentId <= 0) {
      this.errorMessage = 'Please enter a valid Student ID.';
      this.successMessage = '';
      this.autoClearMessages();
      this.cdr.detectChanges();
      return;
    }

    // Clear previous messages immediately
    this.successMessage = '';
    this.errorMessage = '';

    this.classroomService.markAttendance(this.classroomId, this.studentId).subscribe({
      next: (data) => {
        // Show backend success message if exists
        this.successMessage = (data as any)?.message || 'Attendance marked successfully!';
        this.errorMessage = '';
        this.studentId = 0;
        this.loadAttendance();
        this.autoClearMessages();
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = err.error?.message || 'Failed to mark attendance.';
        this.successMessage = '';
        this.autoClearMessages();
        this.cdr.detectChanges();
      }
    });
  }

  // Automatically clear messages after 3 seconds
  private autoClearMessages(): void {
    setTimeout(() => {
      this.successMessage = '';
      this.errorMessage = '';
      this.cdr.detectChanges();
    }, 5000);
  }

  cancel(): void {
    this.router.navigate(['/view-classrooms']);
  }
}