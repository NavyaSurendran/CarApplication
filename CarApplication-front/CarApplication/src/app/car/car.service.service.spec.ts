import { TestBed } from '@angular/core/testing';

import { Car.ServiceService } from './car.service.service';

describe('Car.ServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Car.ServiceService = TestBed.get(Car.ServiceService);
    expect(service).toBeTruthy();
  });
});
