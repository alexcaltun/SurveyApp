import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DataViewComponent } from './dataview.component';

describe('DataviewComponent', () => {
  let component: DataviewComponent;
  let fixture: ComponentFixture<DataViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DataViewComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(DataViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
