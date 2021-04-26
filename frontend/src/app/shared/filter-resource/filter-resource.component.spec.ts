import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterResourceComponent } from './filter-resource.component';

describe('FilterResourceComponent', () => {
  let component: FilterResourceComponent;
  let fixture: ComponentFixture<FilterResourceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilterResourceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterResourceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
