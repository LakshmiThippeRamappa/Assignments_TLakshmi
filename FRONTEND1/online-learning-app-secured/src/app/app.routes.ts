import { RouterModule, Routes } from '@angular/router';
import { Menu } from './menu/menu';
import { RegisterUser } from './user-service-components/register-user/register-user';
import { LoginUser } from './user-service-components/login-user/login-user';
import { NgModule } from '@angular/core';
import { ViewUser } from './user-service-components/view-user/view-user';
import { EditUser } from './user-service-components/edit-user/edit-user';
import { DeleteUser } from './user-service-components/delete-user/delete-user';

export const routes: Routes = [

     {path:'',component:Menu},
     {path:'register',component:RegisterUser},
     {path:'login',component:LoginUser},
     {path:'view-users',component:ViewUser},
     {path:'edit-user/:id',component:EditUser},
     {path:'delete-user/:id',component:DeleteUser}
];