import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkerExampleComponent } from './worker-example.component';

describe('WorkerExampleComponent', () => {
  let component: WorkerExampleComponent;
  let fixture: ComponentFixture<WorkerExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WorkerExampleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WorkerExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
