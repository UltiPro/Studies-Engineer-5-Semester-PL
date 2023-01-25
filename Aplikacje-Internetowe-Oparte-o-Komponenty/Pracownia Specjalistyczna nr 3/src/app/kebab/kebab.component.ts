import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-kebab',
  templateUrl: './kebab.component.html',
  styleUrls: ['./kebab.component.css']
})
export class KebabComponent {
  @Input()
  public type: string = '';
  @Input()
  public price: number = 0.0;
  @Input()
  public available: boolean = false;

  public srcImg: string = 'assets/resources/img/png3.png';

  public toppings: string[] = ['cebula', 'jalapenio', 'ser feta', 'ser halumi'];
}