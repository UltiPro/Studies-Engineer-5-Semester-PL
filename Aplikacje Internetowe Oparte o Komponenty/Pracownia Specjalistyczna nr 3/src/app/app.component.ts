import { ThisReceiver } from '@angular/compiler';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'PS3 - Żarełko';
  isPizzaOrKebab: boolean = true;

  ChangeComponentFood(): void {
    this.isPizzaOrKebab = !this.isPizzaOrKebab;
  }
}