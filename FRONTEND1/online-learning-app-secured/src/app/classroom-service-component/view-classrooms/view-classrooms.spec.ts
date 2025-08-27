import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewClassrooms } from './view-classrooms';

describe('ViewClassrooms', () => {
  let component: ViewClassrooms;
  let fixture: ComponentFixture<ViewClassrooms>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewClassrooms]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewClassrooms);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
