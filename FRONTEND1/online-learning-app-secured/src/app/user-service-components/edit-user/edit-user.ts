import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../service/user.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-user',
  imports: [FormsModule,CommonModule],
  templateUrl: './edit-user.html',
  styleUrl: './edit-user.css'
})
export class EditUser implements OnInit{

user: User = { 
  id: 0, 
  uname: '', 
  email: '', 
  pwd: '', 
  role: '' 
};
  userId!: number;
  errorMessage: string = '';
  message:string='';

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private router: Router,
    private cdr:ChangeDetectorRef
  ) {}

   ngOnInit(): void {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
    console.log('inside edit user');

    // fetch user by id
    this.userService.getUserById(this.userId).subscribe({
      next: (data) => {
        console.log(data);
        this.user = data;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Could not load user.';
        this.cdr.detectChanges();
      }
    });
  }

  async updateUser() {
    this.userService.updateUser(this.userId, this.user).subscribe({
      next: () => {
        this.message='User updated successfully!Taking you to view-users!!!';
        setTimeout(()=>this.router.navigate(['/view-users']),1000);
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Update failed.';
        this.message='';
        this.cdr.detectChanges();
      }
    });
  } 

  goToViewUser(){
    this.router.navigate(['/view-users']);
  }

}
