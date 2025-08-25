import { Routes } from '@angular/router';
//import { ViewUser } from './user-service/view-user/view-user';
import { AddUser } from './user-service/add-user/add-user';
import { EditUser } from './user-service/edit-user/edit-user';
import { DeleteUser } from './user-service/delete-user/delete-user';
import { Menu } from './menu/menu';
import { RegisterUser } from './user-service/register-user/register-user';
import { LoginUser } from './user-service/login-user/login-user';

export const routes: Routes = [
    {path:'',component:Menu},
    {path:'register',component:RegisterUser},
    {path:'login',component:LoginUser},
   // {path:'view-user',component:ViewUser},
    {path:'add-user',component:AddUser},
    {path:'edit-user',component:EditUser},
    {path:'delete-user',component:DeleteUser}
];