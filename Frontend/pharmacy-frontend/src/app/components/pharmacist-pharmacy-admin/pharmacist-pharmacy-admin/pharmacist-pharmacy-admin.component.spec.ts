import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacistPharmacyAdminComponent } from './pharmacist-pharmacy-admin.component';

describe('PharmacistPharmacyAdminComponent', () => {
  let component: PharmacistPharmacyAdminComponent;
  let fixture: ComponentFixture<PharmacistPharmacyAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PharmacistPharmacyAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacistPharmacyAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
