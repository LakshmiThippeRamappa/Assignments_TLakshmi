import { Directive, ElementRef, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appTooltip]'
})
export class Tooltip {
  @Input() appTooltip!: string; // Corrected input binding

  private toolTipElement!: HTMLElement;

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  @HostListener('mouseenter') onMouseEnter() {
    if (!this.appTooltip) return;

    this.toolTipElement = this.renderer.createElement('span');
    const text = this.renderer.createText(this.appTooltip);

    this.renderer.appendChild(this.toolTipElement, text);
    this.renderer.appendChild(document.body, this.toolTipElement);

    // Apply styles for visibility
    this.renderer.setStyle(this.toolTipElement, 'position', 'fixed');
    this.renderer.setStyle(this.toolTipElement, 'z-index', '1000');
    this.renderer.setStyle(this.toolTipElement, 'background', 'yellow');
    this.renderer.setStyle(this.toolTipElement, 'color', 'black');
    this.renderer.setStyle(this.toolTipElement, 'padding', '4px 8px');
    this.renderer.setStyle(this.toolTipElement, 'border-radius', '4px');
    this.renderer.setStyle(this.toolTipElement, 'font-size', '12px');
    this.renderer.setStyle(this.toolTipElement, 'pointer-events', 'none');
  }

  @HostListener('mousemove', ['$event']) onMouseMove(event: MouseEvent) {
    if (this.toolTipElement) {
      this.renderer.setStyle(this.toolTipElement, 'top', `${event.clientY + 10}px`);
      this.renderer.setStyle(this.toolTipElement, 'left', `${event.clientX + 10}px`);
    }
  }

  @HostListener('mouseleave') onMouseLeave() {
    if (this.toolTipElement) {
      this.renderer.removeChild(document.body, this.toolTipElement);
      this.toolTipElement = null!;
    }
  }
}
