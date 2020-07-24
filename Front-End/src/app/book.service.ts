import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Book} from './book'
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  public updateBook(book:Book):Observable<any>{
    return this.http.post("http://localhost:8082/bookmanagementmonolithic/manageBook/update",book,
    {responseType:'text'});
  } 
}