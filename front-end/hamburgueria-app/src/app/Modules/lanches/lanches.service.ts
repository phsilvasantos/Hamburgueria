import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Lanches } from './lanches';

@Injectable({
  providedIn: 'root'
})
export class LancheService {

  URL = 'http://localhost:8080/lanches';
  URL_TODOS_LANCHES = 'http://localhost:8080/todosLanches';
  

  constructor(private http: HttpClient) { }

  listarLanches(){
    return this.http.get<Lanches[]>(this.URL)
  }

  listarDetalhes(id: number){
    return this.http.get<Lanches>(this.URL + '/' + id)
  }

  listarTodosLanches(){
    return this.http.get<Lanches[]>(this.URL_TODOS_LANCHES)
  }


}
