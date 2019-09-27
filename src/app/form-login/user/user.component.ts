import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  message: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  loginUser(loginForm) {
    console.log(loginForm.value);
    this.userService.login(loginForm.value).subscribe(() => {
      this.message = 'user login successfully!';
    }, error => {
      this.message = 'error hh';
    });
  }
}
