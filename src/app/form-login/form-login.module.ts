import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormLoginRoutingModule } from './form-login-routing.module';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { UserListComponent } from './user-list/user-list.component';


@NgModule({
  declarations: [RegisterComponent, UserComponent, UserListComponent],
  imports: [
    CommonModule,
    FormLoginRoutingModule,
    HttpClientModule,
    FormsModule
  ]
})
export class FormLoginModule { }
