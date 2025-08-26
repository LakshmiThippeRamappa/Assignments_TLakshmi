
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CourseResponse } from '../model/course-response.model';
import { Course } from '../model/course.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
 
   private baseUrl = 'http://localhost:5002/api/courses';

  constructor(private http: HttpClient) {}

  getAllCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.baseUrl);
  }

  getCourseWithStudents(id: number): Observable<CourseResponse> {
    return this.http.get<CourseResponse>(`${this.baseUrl}/${id}`);
  }

  createCourse(course: Course): Observable<Course> {
    return this.http.post<Course>(this.baseUrl, course);
  }

  updateCourse(id: number, course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.baseUrl}/${id}`, course);
  }

  deleteCourse(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  enrollStudent(courseId: number, studentId: number): Observable<Course> {
    return this.http.post<Course>(`${this.baseUrl}/${courseId}/enroll/${studentId}`, {});
  }

}