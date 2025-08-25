import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { AddUser } from './user-service/add-user/add-user';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,FormsModule,CommonModule,HttpClientModule,BrowserModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
}