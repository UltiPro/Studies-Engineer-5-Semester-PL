import { Component, OnInit } from '@angular/core';
import { Product } from '../types/Product.model';

@Component({
  selector: 'app-diet',
  templateUrl: './diet.component.html',
  styleUrls: ['./diet.component.css']
})
export class DietComponent implements OnInit {
  userDiet=[
    // new Product('Jabłko',46,12.1,0.4,0.4),
    // new Product('Jagodzianki',314,60.6,7.1,5.4),
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
