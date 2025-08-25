import { ChangeDetectorRef, Component } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-user',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login-user.html',
  styleUrls: ['./login-user.css']
})
export class LoginUser {
 

  credentials = { uname: '', pwd: '' };
  message:string = '';
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router,private cdr:ChangeDetectorRef) {}

  login() {

    console.log("Submitting login:", this.credentials);

    this.authService.login(this.credentials).subscribe({
      next: (token: string) => {
        // ✅ Save the token in localStorage
        localStorage.setItem('authToken', token);

        this.message = 'Login successful!';
        this.errorMessage = ''; // clear error
        // redirect to view-users
        setTimeout(() => this.router.navigate(['/view-users']), 1000);
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = 'Invalid username or password';
        console.error('Login error:', err);
        this.message = ''; // clear success
        this.cdr.detectChanges();
      }
    });
  }

}
