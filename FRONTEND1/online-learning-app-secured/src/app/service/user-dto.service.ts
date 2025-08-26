import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDTO } from '../model/user-dto.model';

@Injectable({
  providedIn: 'root'
})
export class UserDTOService {
   private baseUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) {}

  getAllStudents(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>(this.baseUrl + '?role=STUDENT');
  }
}