import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators'
import { Lanches } from './lanches';

@Injectable({
  providedIn: 'root'
})
export class LancheService {

  url = 'http://localhost:8080/lanches';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getLanches(): Observable<Lanches[]> {
    return this.http.get<Lanches[]>(this.url)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  handleError(error: HttpErrorResponse){
    let errorMessage = '';
    if(error.error instanceof ErrorEvent){
      errorMessage = error.error.message;
    } else {
      errorMessage = 'Código do erro: ${error.status}, ' + 'mensagem: ${error.message}';
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
