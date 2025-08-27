import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomDetails } from './classroom-details';

describe('ClassroomDetails', () => {
  let component: ClassroomDetails;
  let fixture: ComponentFixture<ClassroomDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassroomDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClassroomDetails);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
