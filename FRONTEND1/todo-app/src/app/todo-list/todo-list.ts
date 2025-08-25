import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { TodoItem } from "../todo-item/todo-item";
import { UserRole } from '../model/user-role.enum';
import { FormsModule } from '@angular/forms';
import { Highlight } from "../highlight/highlight";
import { Tooltip } from '../directives/tooltip';
import { ReversePipe } from "../pipes/reverse-pipe";



@Component({
  selector: 'app-todo-list',
  imports: [CommonModule, TodoItem, FormsModule, Highlight, Tooltip, ReversePipe],
  templateUrl: './todo-list.html',
  styleUrl: './todo-list.css'
})


export class TodoList {
  @Input() todos:string[]=[];
  @Output() todoRemoved = new EventEmitter<number>();
   role: UserRole = UserRole.USER;
  UserRole = UserRole;  // <-- Expose Enum to Template

  isImportant=true;
isActive=false;
today= new Date();
user ={name:'Lakshmi', role:'Admin'}


  remove(index:number){
    this.todoRemoved.emit(index);
  }

}
