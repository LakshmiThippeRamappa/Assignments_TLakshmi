import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-todo-item',
  imports: [CommonModule],
  templateUrl: './todo-item.html',
  styleUrl: './todo-item.css'
})
export class TodoItem {

  @Input() todo:any;
  @Output() remove= new EventEmitter<void>();

  removeTodo(){
    this.remove.emit();
  }
}
