import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Suporte } from '../models/suporte';

@Injectable({
  providedIn: 'root'
})
export class SuporteService {

  constructor(private http: HttpClient) { }

  findById(id: any): Observable<Suporte> {
    return this.http.get<Suporte>(`http://localhost:8080/suporte/${id}`);
  }
  
  findAll(): Observable<Suporte[]> {
    return this.http.get<Suporte[]>('http://localhost:8080/suporte');
  }

  create( suporte: Suporte): Observable<Suporte> {
    return this.http.post<Suporte>('http://localhost:8080/suporte', suporte);
  }

  update( suporte: Suporte): Observable<Suporte> {
    return this.http.put<Suporte>(`http://localhost:8080/suporte/${suporte.id}`, suporte);
  }

  delete(id: any): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/suporte/${id}`);
  }
}
