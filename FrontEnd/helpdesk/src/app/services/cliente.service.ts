import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  findById(id: any): Observable<Cliente> {
    return this.http.get<Cliente>(`http://localhost:8080/clientes/${id}`);
  }
  
  findAll(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>('http://localhost:8080/clientes');
  }

  create( cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>('http://localhost:8080/clientes', cliente);
  }

  update( cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`http://localhost:8080/clientes/${cliente.id}`, cliente);
  }

  delete(id: any): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/clientes/${id}`);
  }
}
