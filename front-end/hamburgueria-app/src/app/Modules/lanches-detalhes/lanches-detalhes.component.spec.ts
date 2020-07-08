import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LanchesDetalhesComponent } from './lanches-detalhes.component';

describe('LanchesDetalhesComponent', () => {
  let component: LanchesDetalhesComponent;
  let fixture: ComponentFixture<LanchesDetalhesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LanchesDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LanchesDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
