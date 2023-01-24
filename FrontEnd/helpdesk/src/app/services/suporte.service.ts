import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Suporte } from '../models/suporte';

@Injectable({
  providedIn: 'root'
})
export class SuporteService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Suporte[]> {
    return this.http.get<Suporte[]>('http://localhost:8080/suporte');
  }
}
