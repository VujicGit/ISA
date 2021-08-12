import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DermatologistHomepageComponent } from './dermatologist-homepage.component';

describe('DermatologistHomepageComponent', () => {
  let component: DermatologistHomepageComponent;
  let fixture: ComponentFixture<DermatologistHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DermatologistHomepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DermatologistHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
