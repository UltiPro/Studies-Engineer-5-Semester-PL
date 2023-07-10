import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  name!: string;
  surname!: string;
  index_nr!: number;

  ngOnInit(): void {
    this.name = "Ala";
    this.surname = "Makota";
    this.index_nr = 12345;
  }
}