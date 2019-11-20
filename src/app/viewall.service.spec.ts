import { TestBed } from '@angular/core/testing';

import { ViewallService } from './viewall.service';

describe('ViewallService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewallService = TestBed.get(ViewallService);
    expect(service).toBeTruthy();
  });
});
