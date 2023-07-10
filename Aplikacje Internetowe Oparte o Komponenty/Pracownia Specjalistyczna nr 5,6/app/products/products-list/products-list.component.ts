import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/types/Product.model';
import { ProductPostsService } from '../product-posts.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css'],
})
export class ProductsListComponent implements OnInit {
  productList: Product[] = [];
  searchValue: string = '';
  searchInput: string = '';
  showEdit = false;
  addingToDiet = false;
  productToEdit: Product;
  productToAddToDiet: Product;

  constructor(
    private productPostsServer: ProductPostsService,
    private productService: ProductService
  ) {
    this.productService.onEditEvent.subscribe((product: Product) => {
      this.productToEdit = product;
      this.showEdit = true;
    });
    this.productService.closeEditEvent.subscribe(() => {
      this.showEdit = false;
    });
    this.productService.onAddToDietEvent.subscribe((product: Product) => {
      this.productToAddToDiet = product;
      this.addingToDiet = true;
    });
    this.productService.closeAddingToDiet.subscribe(() => {
      this.addingToDiet = false;
    });
    this.productService.productWasEdited.subscribe((product: Product) => {
      console.log(this.productList);
      const id = this.productList.findIndex((p) => p.Id === product.Id);
      this.productList[id] = product;
      console.log(this.productList);
    });
  }

  ngOnInit(): void {
    this.productPostsServer.featchPosts().subscribe((posts) => {
      // this.productList = posts.sort((a, b) => a.Name.localeCompare(b.Name));
      this.productList = posts.sort((a, b) => a.Name.localeCompare(b.Name));
      // this.productList.);
    });
  }

  getProducts(id: string): void {
    this.productList = this.productList.filter((prod) => prod.Id !== id);
  }

  // updateProducts(product: Product) {
  //   // console.log('dupa', product.Id);
  //   // const id = this.productList.findIndex((p) => (p.Id = product.Id));
  //   // console.log(this.productList[id]);
  //   // this.productList[id] = product;
  //   // console.log(this.productList[id]);
  // }

  onInputChanged(value: string): void {
    this.searchValue = value;
  }
}