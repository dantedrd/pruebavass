import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateclientsmodalComponent } from './createclientsmodal.component';

describe('CreateclientsmodalComponent', () => {
  let component: CreateclientsmodalComponent;
  let fixture: ComponentFixture<CreateclientsmodalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateclientsmodalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateclientsmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
