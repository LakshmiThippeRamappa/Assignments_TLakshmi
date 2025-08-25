import { Component } from '@angular/core';
import { AuthService } from '../../service/auth-service';

@Component({
  selector: 'app-login-user',
  imports: [],
  templateUrl: './login-user.html',
  styleUrl: './login-user.css'
})
export class LoginUser {

  loginData = {
    email: '',
    pwd: ''
  };

  constructor(private authService: AuthService) {}

  onLogin() {
    console.log("Login request:", this.loginData);

    this.authService.login(this.loginData).subscribe({
      next: (res) => {
        alert(res); // "Login successful"
      },
      error: (err) => {
        console.error("Login failed:", err);
        alert("Invalid credentials!");
      }
    });
  }
}
