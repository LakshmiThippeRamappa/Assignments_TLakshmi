import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { Todo } from './todo/todo';

export const routes: Routes = [
    {path:'todos',component:Todo}
];