import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PS2';
  ja = new Student('Patryk', 'Wójtowicz', 109960);
}

class Student {
  constructor(private _name: string, private _surname: string, private _idx: number) {
    this._name = _name;
    this._surname = _surname;
    this._idx = _idx;
  }
  public get name(): string {
    return this._name;
  }
  public set name(_name: string) {
    this._name = _name;
  }
  public get surname(): string {
    return this._surname;
  }
  public set surname(_surname: string) {
    this._surname = _surname;
  }
  public get idx(): number {
    return this._idx;
  }
  public set idx(_idx: number) {
    this._idx = _idx;
  }
}