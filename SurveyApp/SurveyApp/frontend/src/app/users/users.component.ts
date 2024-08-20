import { Component, OnInit } from '@angular/core';
import { IUser } from './user.model';
import { CommonModule } from '@angular/common';
import { UserService } from '../user.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements OnInit {
  users: IUser[];
  user: IUser = { id: 0, name: "qweqwe", email: "asdfasdf" };

  constructor(private userService: UserService, private router: Router) {



    this.users = [];
    //   this.users = [
    //   {
    //     id: 1,
    //     name: "Ghita",
    //     email: "vxzcvzxcvzxc"
    //   },
    //   {
    //     id: 2,
    //     name: "Ghita",
    //     email: "vxzcvzxcvzxc"
    //   },
    //   {
    //     id: 3,
    //     name: "Ghita",
    //     email: "vxzcvzxcvzxc"
    //   }
    // ];
  }


  ngOnInit() {
    //this.userService.addUser( this.user );

    this.userService.getUsers().subscribe(users => {
      this.users = users;
    })
  }


  deleteUser(userId: number): void {
    this.userService.deleteUser(userId).subscribe(() => {
      this.userService.getUsers().subscribe(users => {
        this.users = users;
      });
    });
  }

  editUser(userId: number): void {
    this.router.navigate(['/edit-user', userId]);
  }

  addUser(): void {
    this.router.navigate(['/add-user']);
  }
}
