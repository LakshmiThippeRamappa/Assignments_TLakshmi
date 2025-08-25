import { Component } from '@angular/core';
import { Userservice } from '../../service/userservice';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-user',
  imports: [FormsModule],
  templateUrl: './add-user.html',
  styleUrl: './add-user.css'
})
export class AddUser {
  user={
    uname:'',
    email:'',
    pwd:'',
    role:''
  }
  message='';
  constructor(private userService:Userservice,private router:Router){}

  async onSubmit() {
    console.log("Submitting user:", this.user);

    this.userService.addUser(this.user).subscribe({
      next: (response) => {
        console.log("User saved:", response);
        this.message = "User added successfully!";
        this.router.navigate(['/user']);
      },
      error: (err) => {
        console.error("Error while saving user:", err);
        this.message = "Error adding user!";
      }
    });
  }
}