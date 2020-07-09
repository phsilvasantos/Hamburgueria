import { Component, OnInit } from '@angular/core';
import { LancheService } from '../lanches/lanches.service';
import { Lanches } from '../lanches/lanches';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-todos-lanches',
  templateUrl: './todos-lanches.component.html',
  styleUrls: ['./todos-lanches.component.css']
})
export class TodosLanchesComponent implements OnInit {

  lancheService: LancheService;
  lista: Lanches[];
  id: number = 0;
  lanche: Lanches;

  constructor(private ls: LancheService, private activatedRoute: ActivatedRoute) {
    this.lancheService = ls;
   }

  async ngOnInit() {
    this.ls.listarTodosLanches().subscribe(res => {
      this.lista = res;
      console.log(this.lista);
    }, err => {
      console.log(err);
    });
  }

  atualizar() {
    this.id = this.activatedRoute.snapshot.params.id;
    this.lancheService.atualizaLanche(this.lanche, this.id);
  }

}
