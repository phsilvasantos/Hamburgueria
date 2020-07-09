import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Lanches } from './lanches';
import { catchError, tap, map } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LancheService {

  URL = 'http://localhost:8080/lanches';
  URL_TODOS_LANCHES = 'http://localhost:8080/todosLanches';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  listarLanches(): Observable<Lanches[]> {
    return this.http.get<Lanches[]>(this.URL)
      .pipe(
        tap(lanches => console.log('leu os lanches')),
        catchError(this.handleError('listarLanches', []))
      );
  }

  listarDetalhes(id: number): Observable<Lanches> {
    return this.http.get<Lanches>(this.URL + '/' + id)
      .pipe(
        tap(_ => console.log('leu o lanche')),
        catchError(this.handleError<Lanches>('listarDetalhes id=${id}'))
      );
  }

  listarTodosLanches() {
    return this.http.get<Lanches[]>(this.URL_TODOS_LANCHES)
      .pipe(
        tap(l => console.log('leu todos os lanches')),
        catchError(this.handleError('listarTodosLanches', []))
      );
  }

  atualizaLanche(lanche: Lanches, id: number): Observable<any> {
    return this.http.put(this.URL + '/' + id, lanche, this.httpOptions)
      .pipe(
        tap(_ => console.log('atualizado o lanche')),
        catchError(this.handleError<any>('atualizaLanche'))
      );
  }

  adicionarLanche(lanche: Lanches): Observable<Lanches> {
    return this.http.post<Lanches>(this.URL, lanche, this.httpOptions)
      .pipe(
        tap((lanche: Lanches) => console.log('adicionou o lanche')),
        catchError(this.handleError<Lanches>('adicionarLanche'))
      );
  }

  deletarLanche(id: number): Observable<Lanches> {
    return this.http.delete<Lanches>(this.URL + '/' + id, this.httpOptions)
      .pipe(
        tap(_ => console.log('removeu o lanche')),
        catchError(this.handleError<Lanches>('deletarLanche'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      return of(result as T);
    };
  }

}
