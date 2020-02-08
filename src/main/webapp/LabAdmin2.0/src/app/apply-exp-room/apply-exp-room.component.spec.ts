import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyExpRoomComponent } from './apply-exp-room.component';

describe('ApplyExpRoomComponent', () => {
  let component: ApplyExpRoomComponent;
  let fixture: ComponentFixture<ApplyExpRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplyExpRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplyExpRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
