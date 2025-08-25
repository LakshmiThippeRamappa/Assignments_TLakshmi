import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class Highlight {

  constructor(private el:ElementRef) {
    //Change the element's text color
    this.el.nativeElement.style.color='blue';
    this.el.nativeElement.style.backgroundColor='yellow';
   }

}
