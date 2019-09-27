import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from './register/register.component';
import {UserComponent} from './user/user.component';
import {UserListComponent} from './user-list/user-list.component';


const routes: Routes = [
  {path: 'create-user', component: RegisterComponent},
  {path: 'list-user', component: UserListComponent},
  {path: 'login-user', component: UserComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormLoginRoutingModule { }
