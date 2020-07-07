import { Component, OnInit } from '@angular/core';
import { Lanches } from './lanches';
import { LancheService } from './lanches.service';

@Component({
  selector: 'app-lanches',
  templateUrl: './lanches.component.html',
  styleUrls: ['./lanches.component.css']
})
export class LanchesComponent implements OnInit {

  lanches: Lanches[];

  constructor(private lancheService: LancheService) { }

  ngOnInit() {
    this.getLanches();
  }

  getLanches(){
    this.lancheService.getLanches().subscribe((lanches: Lanches[]) => {
      this.lanches = lanches;
    });
    console.log(this.lanches);
  }

}
