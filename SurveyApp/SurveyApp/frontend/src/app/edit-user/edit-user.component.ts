import { Component, OnInit } from '@angular/core';
import { IUser } from '../users/user.model';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-user',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './edit-user.component.html',
  styleUrl: './edit-user.component.css'
})
export class EditUserComponent implements OnInit {
  user: IUser = { id: 0, name: '', email: '' };
  isEditMode = false;

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute,) {

  }

  ngOnInit() {
    const userId = this.route.snapshot.paramMap.get('id');
    if (userId) {
      this.isEditMode = true;
      this.userService.getUserById(+userId).subscribe(user => {
        this.user = user;
      });
    }
  }

  addUser() {
    this.userService.addUser(this.user).subscribe({
      next: () => this.router.navigate(['/home'])
    });
  }

  saveUser(): void {
    if (this.isEditMode) {
      this.userService.updateUser(this.user).subscribe(() => this.router.navigate(['/home']));
    } else {
      this.userService.addUser(this.user).subscribe(() => this.router.navigate(['/home']));
    }
  }
}
