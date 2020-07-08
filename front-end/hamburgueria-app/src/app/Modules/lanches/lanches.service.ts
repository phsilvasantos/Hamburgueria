import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Lanches } from './lanches';

@Injectable({
  providedIn: 'root'
})
export class LancheService {

  url = 'http://localhost:8080/lanches';

  constructor(private http: HttpClient) { }

  listarLanches(){
    return this.http.get<Lanches[]>(this.url)
  }

  listarDetalhes(id: number){
    return this.http.get<Lanches>(this.url + '/' + id)
  }
}
