import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TodosLanchesComponent } from './todos-lanches.component';

describe('TodosLanchesComponent', () => {
  let component: TodosLanchesComponent;
  let fixture: ComponentFixture<TodosLanchesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TodosLanchesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TodosLanchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
