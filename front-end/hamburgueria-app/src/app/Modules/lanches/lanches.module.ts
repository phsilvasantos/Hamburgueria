import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LanchesComponent } from '../lanches/lanches.component';



@NgModule({
  declarations: [LanchesComponent],
  imports: [
    CommonModule
  ],
  exports: [LanchesComponent]
})
export class LanchesModule { }
