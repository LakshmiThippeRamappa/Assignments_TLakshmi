import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = "http://localhost:5001/auth"; // ✅ Your Spring Boot backend

  constructor(private http: HttpClient) {}

  register(user: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/register`, user, { responseType: 'text' });
  }

  login(user: any): Observable<string> {
    return this.http.post(`${this.baseUrl}/login`, user, { responseType: 'text' });
  }
}
