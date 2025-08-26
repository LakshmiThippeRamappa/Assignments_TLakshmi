import { TestBed } from '@angular/core/testing';

import { UserDTOService } from './user-dto.service';

describe('UserDTOService', () => {
  let service: UserDTOService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserDTOService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
