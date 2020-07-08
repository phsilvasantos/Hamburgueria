import { Component, OnInit } from '@angular/core';
import { Lanches } from './lanches';
import { LancheService } from './lanches.service';

@Component({
  selector: 'app-lanches',
  templateUrl: './lanches.component.html',
  styleUrls: ['./lanches.component.css']
})
export class LanchesComponent implements OnInit {

  lancheService: LancheService;
  lista: Lanches[];

  constructor(ls: LancheService) {
    this.lancheService = ls
   }

  async ngOnInit() {
    let arrayLanche = await this.lancheService.listarLanches().toPromise();
    this.lista = arrayLanche;
  }

}
