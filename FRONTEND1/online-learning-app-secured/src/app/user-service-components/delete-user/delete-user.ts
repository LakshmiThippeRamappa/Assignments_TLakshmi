import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-delete-user',
  imports: [CommonModule,FormsModule],
  templateUrl: './delete-user.html',
  styleUrl: './delete-user.css'
})
export class DeleteUser implements OnInit{
   userId!: number;
  message = '';
  errorMessage = '';

  constructor(private route: ActivatedRoute,private userService: UserService, private router: Router,private cdr:ChangeDetectorRef) {}

  ngOnInit(): void {
    // Get ID from route parameter
    this.userId = +this.route.snapshot.paramMap.get('id')!;
  }

  deleteUser() {
    this.userService.deleteUser(this.userId).subscribe({
      next: () => {
        this.message = `User with ID ${this.userId} deleted successfully!`;
        // Redirect to view users after a short delay
          setTimeout(() => this.router.navigate(['/view-users']), 3000);
          this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('Delete failed:', err);
        this.errorMessage = 'Delete failed. Make sure token is valid and ID exists.';
        this.message='';
        this.cdr.detectChanges();
      }
    });
  }
  goToViewUser(){
    this.router.navigate(['/view-users']);
  }
}
