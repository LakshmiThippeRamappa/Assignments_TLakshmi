import { ChangeDetectorRef, Component } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register-user',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register-user.html',
  styleUrls: ['./register-user.css']
})
export class RegisterUser {
  user = { uname: '', email: '', pwd: '', role: '' };
  successMessage = '';
  errorMessage = '';
  showLoginLink = false; // new flag to show login link after registration

  constructor(private authService: AuthService, private router: Router,private cdr:ChangeDetectorRef) {}

  async onRegister() {
    this.successMessage = '';
    this.errorMessage = '';
    this.showLoginLink = false;
    console.log("submitting user:",this.user);
    this.authService.register(this.user).subscribe({
      next: (response) => {
        console.log("User saved:", response);
        this.successMessage = " User registered successfully!";
        this.showLoginLink = true; // show login link
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error("Error while saving user:", err.status);
        if (err.status === 409) {
          this.errorMessage = " Email already exists!";
          this.successMessage='';
        } else {
          this.errorMessage = " Registration failed. Please try again.";
          this.successMessage='';
        }
        this.cdr.detectChanges();
      }
    });
  }

  goToLogin() {
    this.router.navigate(['/login']); // navigate to login page
  }
}
