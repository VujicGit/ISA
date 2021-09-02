import { TestBed } from '@angular/core/testing';

import { EmploymentServiceService } from './employment-service.service';

describe('EmploymentServiceService', () => {
  let service: EmploymentServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmploymentServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
