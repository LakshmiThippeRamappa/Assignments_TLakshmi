import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Classroom } from '../../model/classroom-models/classroom.model';
import { ClassroomService } from '../../service/classroom-service/classroom.service';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-classrooms',
  imports: [RouterLink,CommonModule,FormsModule],
  templateUrl: './view-classrooms.html',
  styleUrl: './view-classrooms.css'
})
export class ViewClassrooms implements OnInit {
  classrooms: Classroom[] = [];
  message: string = '';

  constructor(
    private classroomService: ClassroomService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    console.log('ViewClassrooms component initialized');
    this.loadClassrooms();
  }

  loadClassrooms(): void {
    console.log('Fetching classrooms from service...');
    this.classroomService.getAllClassrooms().subscribe({
      next: (data) => {
        console.log('Classrooms data received:', data);
        this.classrooms = data;
        this.message = data.length > 0 ? 'Classrooms loaded successfully ' : 'No classrooms found ';
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Error while fetching classrooms:', err.error.error);
        this.message = 'Failed to load classrooms. Please try again later.';
        this.cdr.detectChanges();
      }
    });
  }
}