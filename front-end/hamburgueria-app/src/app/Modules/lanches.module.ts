import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LanchesComponent } from './lanches/lanches.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { LanchesDetalhesComponent } from './lanches-detalhes/lanches-detalhes.component';
import { TodosLanchesComponent } from './todos-lanches/todos-lanches.component';

@NgModule({
  declarations: [LanchesComponent, 
    LanchesDetalhesComponent, 
    TodosLanchesComponent],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule
  ],
  exports: [LanchesComponent, 
    LanchesDetalhesComponent,
    TodosLanchesComponent]
})
export class LanchesModule { }
