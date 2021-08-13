import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DermatologistReportComponent } from './dermatologist-report.component';

describe('DermatologistReportComponent', () => {
  let component: DermatologistReportComponent;
  let fixture: ComponentFixture<DermatologistReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DermatologistReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DermatologistReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
