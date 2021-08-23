import { TestBed } from '@angular/core/testing';

import { DermatologistServiceService } from './dermatologist-service.service';

describe('DermatologistServiceService', () => {
  let service: DermatologistServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DermatologistServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
