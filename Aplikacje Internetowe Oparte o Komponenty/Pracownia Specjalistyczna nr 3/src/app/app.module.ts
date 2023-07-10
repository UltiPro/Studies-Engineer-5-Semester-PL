import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PizzaComponent } from './pizza/pizza.component';
import { KebabComponent } from './kebab/kebab.component';

@NgModule({
  declarations: [
    AppComponent,
    PizzaComponent,
    KebabComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }