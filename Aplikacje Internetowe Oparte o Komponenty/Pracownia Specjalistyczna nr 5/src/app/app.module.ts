import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductComponent } from './products/product/product.component';
import { ProductsListComponent } from './products/products-list/products-list.component';
import { DietComponent } from './diet/diet.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ProductsListComponent,
    DietComponent,
    AddProductComponent,
  ],
  imports: [BrowserModule, FormsModule,HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
