import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepotOwnerComponent } from './depot-owner.component';

describe('DepotOwnerComponent', () => {
  let component: DepotOwnerComponent;
  let fixture: ComponentFixture<DepotOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DepotOwnerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DepotOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
