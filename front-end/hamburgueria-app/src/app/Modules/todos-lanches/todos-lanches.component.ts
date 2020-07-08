import { Component, OnInit } from '@angular/core';
import { LancheService } from '../lanches/lanches.service';
import { Lanches } from '../lanches/lanches';

@Component({
  selector: 'app-todos-lanches',
  templateUrl: './todos-lanches.component.html',
  styleUrls: ['./todos-lanches.component.css']
})
export class TodosLanchesComponent implements OnInit {

  lancheService: LancheService;
  lista: Lanches[];

  constructor(ls: LancheService) {
    this.lancheService = ls
   }

  async ngOnInit() {
    let arrayLanche = await this.lancheService.listarTodosLanches().toPromise();
    this.lista = arrayLanche;
  }

}
