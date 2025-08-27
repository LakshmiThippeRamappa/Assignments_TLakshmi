import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ClassroomResponse } from '../../model/classroom-models/classroom-response.model';
import { ClassroomService } from '../../service/classroom-service/classroom.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-classroom-details',
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './classroom-details.html',
  styleUrl: './classroom-details.css'
})
export class ClassroomDetails implements OnInit{

  classroom?: ClassroomResponse;
  errorMessage: string = '';

  constructor(
    private route: ActivatedRoute,
    private classroomService: ClassroomService,
    private cdr:ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.loadClassroomDetails(id);
  }

  private loadClassroomDetails(id: number): void {
    this.classroomService.getClassroomWithDetails(id).subscribe({
      next: (data) => {
        this.classroom = data;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = err.error?.message || 'Failed to load classroom details.';
        this.cdr.detectChanges();
      }
    });
  }
}
