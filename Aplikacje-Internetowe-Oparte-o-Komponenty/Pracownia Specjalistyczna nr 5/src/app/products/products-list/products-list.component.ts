import { Component, OnInit } from '@angular/core';
import { PostProduct, Product } from 'src/app/types/Product.model';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css'],
})
export class ProductsListComponent implements OnInit {
  productList:PostProduct[] = [];
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getProducts();
  }
  getProducts() {
    this.http
      .get<{ [key: string]: PostProduct }>(
        'https://angular-projekt-7b1f8-default-rtdb.firebaseio.com/post.json'
      )
      .pipe(
        map((responseData) => {
          const postsArray:PostProduct[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              // console.log(responseData[key].Name);
              postsArray.push({ ...responseData[key],id: key});
            }
          }
          return postsArray;
        })
      )
      .subscribe((posts) => {
        this.productList = posts;
      });
    //   this.http
    //     .get<{ [key: string]: Product }>(
    //       'https://angular-projekt-7b1f8-default-rtdb.firebaseio.com/post.json'
    //     )
    //     .pipe(
    //       map((resData) => {
    //         const producteArray: Product[] = [];
    //         console.log(resData);
    //         for (const key in resData) {
    //           if (resData.hasOwnProperty(key)) {
    //             // producteArray.push({...resData[key]})
    //             console.log(resData[key]);
    //             producteArray.push(new Product(...resData[key]));
    //             // console.log(resData[key].Name);
    //           }
    //         }
    //         return producteArray;
    //       })
    //     )
    //     .subscribe((products: Product[]) => {
    //       this.productList = products;
    //       console.log(products);
    //     });
    // }
    
  }
}
