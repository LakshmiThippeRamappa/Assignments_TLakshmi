import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
   private baseUrl = 'http://localhost:5001/api/users';

  constructor(private http: HttpClient, private authService: AuthService) {}

  // No security
  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl);
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  updateUser(id: number, user: User): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, user);
  }

  // Delete user (WITH TOKEN)
  deleteUser(id: number): Observable<any> {
    const token = localStorage.getItem('authToken'); // ✅ fetch token
     if (!token) {
      throw new Error('No auth token found. Please login first.');
    }
    console.log("Token: ",token);
    // const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    // Make sure header is correct
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    console.log('Deleting user ID:', id, 'with token:', token);
    return this.http.delete(`${this.baseUrl}/${id}`, { headers, responseType: 'text' });
  }

}
