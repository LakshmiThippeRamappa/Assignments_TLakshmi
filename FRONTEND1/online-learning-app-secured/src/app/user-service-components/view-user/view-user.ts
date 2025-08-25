import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { Router } from '@angular/router';
import { UserService } from '../../service/user.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-user',
  standalone:true,
  imports: [FormsModule,CommonModule],
  templateUrl: './view-user.html',
  styleUrls: ['./view-user.css']
})
export class ViewUser implements OnInit {
 users: any[] = [];
  errorMessage: string = '';

  constructor(private userService: UserService, private router: Router,private cdr:ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers() {
    this.userService.getAllUsers().subscribe({
      next: (data) => {
        this.users = data;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.errorMessage = 'Error fetching users';
        console.error(err);
        this.cdr.detectChanges();
      }
    });
  }
  deleteUser(id: number) {
    // this.userService.deleteUser(id).subscribe({
    //   next: () => {
    //     alert('User deleted successfully');
    //     this.loadUsers(); // refresh list
    //     this.cdr.detectChanges();
    //   },
    //   error: (err) => {
    //     console.error('Delete failed:', err);
    //     alert('Delete failed, maybe token is missing or expired.');
    //     this.cdr.detectChanges();
    //   }
    // });
    this.router.navigate(['/delete-user',id]);
  }

  editUser(id: number) {
    console.log(" inside edit user")
    this.router.navigate(['/edit-user', id]); // navigate to update component
  }
}