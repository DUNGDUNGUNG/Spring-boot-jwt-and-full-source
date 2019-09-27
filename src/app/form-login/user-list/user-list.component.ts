import {Component, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {IUser} from '../user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: IUser;
  message: string;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.getList();
  }

  getList() {
    const updateBooksEvent = this.userService.getList();

    updateBooksEvent.subscribe(newList => {
      this.users = newList;
    }, error => {
      console.log('Lỗi gì đó!', error);
      this.message = error.message;
    });
  }

}
