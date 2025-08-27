import { RouterModule, Routes } from '@angular/router';
import { Menu } from './menu/menu';
import { RegisterUser } from './user-service-components/register-user/register-user';
import { LoginUser } from './user-service-components/login-user/login-user';
import { NgModule } from '@angular/core';
import { ViewUser } from './user-service-components/view-user/view-user';
import { EditUser } from './user-service-components/edit-user/edit-user';
import { DeleteUser } from './user-service-components/delete-user/delete-user';
import { ViewCourses } from './course-service-components/view-courses/view-courses';
import { AddCourse } from './course-service-components/add-course/add-course';
import { EditCourse } from './course-service-components/edit-course/edit-course';
import { CourseDetails } from './course-service-components/course-details/course-details';
import { DeleteCourse } from './course-service-components/delete-course/delete-course';
import { EnrollStudent } from './course-service-components/enroll-student/enroll-student';
import { ViewClassrooms } from './classroom-service-component/view-classrooms/view-classrooms';
import { AddClassroom } from './classroom-service-component/add-classroom/add-classroom';
import { EditClassroom } from './classroom-service-component/edit-classroom/edit-classroom';
import { DeleteClassroom } from './classroom-service-component/delete-classroom/delete-classroom';
import { ClassroomDetails } from './classroom-service-component/classroom-details/classroom-details';
import { AttendanceManagement } from './classroom-service-component/attendance-management/attendance-management';

export const routes: Routes = [

     {path:'',component:Menu},
     {path:'register',component:RegisterUser},
     {path:'login',component:LoginUser},
     {path:'view-users',component:ViewUser},
     {path:'edit-user/:id',component:EditUser},
     {path:'delete-user/:id',component:DeleteUser},

     {path:'view-courses',component:ViewCourses},
     {path:'add-course',component:AddCourse},
     {path:'edit-course/:id',component:EditCourse},
     {path:'course-details/:id',component:CourseDetails},
     {path:'delete-course/:id',component:DeleteCourse},
     {path:'enroll-student',component:EnrollStudent},
     {path:'enroll-student/:courseId',component:EnrollStudent},

     {path:'view-classrooms',component:ViewClassrooms},
     {path:'add-classroom',component:AddClassroom},
     {path:'edit-classroom/:id',component:EditClassroom},
     {path:'delete-classroom/:id',component:DeleteClassroom},
     {path:'classroom-details/:id',component:ClassroomDetails},
     {path:'attendance-management/:id/attendance',component:AttendanceManagement}
];