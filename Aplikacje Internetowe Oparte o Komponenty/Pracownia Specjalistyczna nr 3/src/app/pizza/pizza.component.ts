import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})

export class PizzaComponent {
  @Input()
  public type: string = '';
  @Input()
  public price: number = 0.0;
  @Input()
  public available: boolean = false;
  @Input()
  public srcImg: string = '';
  @Input()
  public toppings: string[] = [''];
}