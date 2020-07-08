import { Component, OnInit } from '@angular/core';
import { LancheService } from '../lanches/lanches.service';
import { Lanches } from '../lanches/lanches';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lanches-detalhes',
  templateUrl: './lanches-detalhes.component.html',
  styleUrls: ['./lanches-detalhes.component.css']
})
export class LanchesDetalhesComponent implements OnInit {

  lancheService: LancheService;
  lanche: Lanches;

  id: number = 0;

  constructor(private ls: LancheService, private activatedRoute: ActivatedRoute) {
    this.lancheService = ls;
   }

  async ngOnInit() {
    this.id = this.activatedRoute.snapshot.params.id;
    let lanche = await this.lancheService.listarDetalhes(this.id).toPromise();
    this.lanche = lanche;
    console.log(this.id)
    console.log(this.lanche)
  }

}
