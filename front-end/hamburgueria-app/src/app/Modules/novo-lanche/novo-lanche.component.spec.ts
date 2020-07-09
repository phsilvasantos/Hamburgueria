import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NovoLancheComponent } from './novo-lanche.component';

describe('NovoLancheComponent', () => {
  let component: NovoLancheComponent;
  let fixture: ComponentFixture<NovoLancheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NovoLancheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NovoLancheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
