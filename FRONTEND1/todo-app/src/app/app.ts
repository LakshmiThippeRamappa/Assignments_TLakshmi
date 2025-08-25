import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TodoList } from './todo-list/todo-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TodoList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
    todos:any=[
   {task: 'Learn Angular',dueDate:new Date(2025,7,25)},
     {task:'Practice Components',dueDate:new Date(2025,8,25)},
     {task: 'Build Todo App',dueDate:new Date(2025,8,26)}
    ];
//  todos:string[]=[];
  protected readonly title = 'todo-app';


  addTodo(newTodo: any){
    if(newTodo.trim()){
      this.todos.push(newTodo);
    }
  }

  removeTodo(index:number){
    this.todos.splice(index,1);
  }
}
