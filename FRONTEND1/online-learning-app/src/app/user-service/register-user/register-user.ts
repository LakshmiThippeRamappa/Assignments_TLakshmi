import { Component } from '@angular/core';
import { AuthService } from '../../service/auth-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  imports: [],
  templateUrl: './register-user.html',
  styleUrl: './register-user.css'
})
export class RegisterUser {
  user = {
    uname: '',
    email: '',
    pwd: '',
    role: ''
  };
  message: string='';

  constructor(private authService: AuthService,private router:Router) {}

  async onRegister() {
    console.log("Submitting user:", this.user);

    this.authService.register(this.user).subscribe({
      next: (response) => {
        console.log("User saved:", response);
        this.message = "User added successfully!";
        this.router.navigate(['/login']);
      },
      error: (err) => {
        console.error("Error while saving customer:", err);
        this.message = "Error adding customer!";
      }
    });
  }
}
