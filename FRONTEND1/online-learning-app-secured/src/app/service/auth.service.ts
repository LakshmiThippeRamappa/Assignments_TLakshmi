import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = "http://localhost:5001/auth"; // ✅ Your Spring Boot backend

  constructor(private http: HttpClient) {}

  register(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, user);
  }

   login(credentials: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/login`, credentials, { responseType: 'text' });
    // backend returns raw token as string
  }

  // Token handling
  getToken(): string | null {
    return localStorage.getItem('authToken');
  }
  //clear token
  logout(): void {
    localStorage.removeItem('authToken');
  }
}