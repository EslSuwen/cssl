import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeachTableComponent } from './teach-table.component';

describe('TeachTableComponent', () => {
  let component: TeachTableComponent;
  let fixture: ComponentFixture<TeachTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeachTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeachTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
