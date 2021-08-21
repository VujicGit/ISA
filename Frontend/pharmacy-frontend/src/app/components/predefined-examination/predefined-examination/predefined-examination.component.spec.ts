import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PredefinedExaminationComponent } from './predefined-examination.component';

describe('PredefinedExaminationComponent', () => {
  let component: PredefinedExaminationComponent;
  let fixture: ComponentFixture<PredefinedExaminationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PredefinedExaminationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PredefinedExaminationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
