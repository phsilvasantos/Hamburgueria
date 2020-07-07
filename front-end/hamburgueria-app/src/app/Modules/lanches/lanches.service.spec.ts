import { TestBed } from '@angular/core/testing';

import { LancheService } from './lanches.service';

describe('LancheService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LancheService = TestBed.get(LancheService);
    expect(service).toBeTruthy();
  });
});
