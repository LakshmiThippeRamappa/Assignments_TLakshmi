import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteClassroom } from './delete-classroom';

describe('DeleteClassroom', () => {
  let component: DeleteClassroom;
  let fixture: ComponentFixture<DeleteClassroom>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeleteClassroom]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteClassroom);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
