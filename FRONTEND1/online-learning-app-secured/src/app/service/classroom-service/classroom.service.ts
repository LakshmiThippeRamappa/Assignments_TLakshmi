import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AttendanceResponse } from '../../model/classroom-models/attendance-response.model';
import { Attendance } from '../../model/classroom-models/attendance.model';
import { ClassroomResponse } from '../../model/classroom-models/classroom-response.model';
import { Classroom } from '../../model/classroom-models/classroom.model';

@Injectable({
  providedIn: 'root'
})
export class ClassroomService {
   private baseUrl = 'http://localhost:5003/api/classrooms'; // ✅ adjust port if needed

  constructor(private http: HttpClient) {}

  // Create Classroom
  createClassroom(classroom: Classroom): Observable<Classroom> {
    return this.http.post<Classroom>(`${this.baseUrl}`, classroom);
  }

  // Get All Classrooms
  getAllClassrooms(): Observable<Classroom[]> {
    return this.http.get<Classroom[]>(`${this.baseUrl}`);
  }

  // Get Classroom by ID
  getClassroomById(id: number): Observable<Classroom> {
    return this.http.get<Classroom>(`${this.baseUrl}/${id}`);
  }

  // Update Classroom
  updateClassroom(id: number, classroom: Classroom): Observable<Classroom> {
    return this.http.put<Classroom>(`${this.baseUrl}/${id}`, classroom);
  }

  // Delete Classroom
  deleteClassroom(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  // Mark Attendance
  markAttendance(classroomId: number, studentId: number): Observable<Attendance> {
    return this.http.post<Attendance>(`${this.baseUrl}/${classroomId}/attendance/${studentId}`, {});
  }

  // Get Attendance (basic, only IDs)
  getAttendanceByClassroom(classroomId: number): Observable<Attendance[]> {
    return this.http.get<Attendance[]>(`${this.baseUrl}/${classroomId}/attendance`);
  }

  // Get Attendance with Student Details
  getAttendanceDetails(classroomId: number): Observable<AttendanceResponse[]> {
    return this.http.get<AttendanceResponse[]>(`${this.baseUrl}/${classroomId}/attendance/details`);
  }

  // Get Classroom with Course + Present Students
  getClassroomWithDetails(id: number): Observable<ClassroomResponse> {
    return this.http.get<ClassroomResponse>(`${this.baseUrl}/${id}/details`);
  }

}
