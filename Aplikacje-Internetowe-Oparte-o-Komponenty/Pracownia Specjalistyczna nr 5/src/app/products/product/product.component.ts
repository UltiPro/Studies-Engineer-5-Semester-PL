import { Component, OnInit,Input } from '@angular/core';
import { PostProduct, Product } from 'src/app/types/Product.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @Input() product!:PostProduct;
  showDetails=false;

  constructor() { }

  ngOnInit(): void {
  }

}
