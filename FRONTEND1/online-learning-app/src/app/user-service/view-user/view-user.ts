import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../../model/types';
import { Userservice } from '../../service/userservice';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-view-user',
  imports: [CommonModule],
  templateUrl: './view-user.html',
  styleUrl: './view-user.css'
})
export class ViewUser implements OnInit {

    users: User[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private userService: Userservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers() {
  console.log("Loading Users...");

  this.userService.getUsers().subscribe({
    next: (data) => {
      console.log("API Response: ", data, Array.isArray(data));
      
      this.users = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.users.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned users length:", this.users.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

// deleteCustomer(id: number|undefined) {
//   if(confirm('ARe you sure to delete this customer?')){
//     this.customerService.deleteCustomer(id).subscribe({
//       next: () =>{
//         alert('Customer deleted successfully');
//         this.loadCustomers();
//       },
//       error:(err) =>{
//         console.error(err);
//         alert("Failed to delete a customer");
//       }
//     })
//   }
// }
// editCustomer(id: number|undefined) {
//   console.log(" inside edit customer")
//   this.router.navigate(['/edit-customer',id]);
// }


}
