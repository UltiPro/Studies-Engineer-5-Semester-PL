import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KebabComponent } from './kebab.component';

describe('KebabComponent', () => {
  let component: KebabComponent;
  let fixture: ComponentFixture<KebabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KebabComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KebabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
