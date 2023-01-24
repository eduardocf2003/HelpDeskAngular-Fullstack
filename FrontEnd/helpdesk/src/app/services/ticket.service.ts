import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from '../models/ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http: HttpClient) { }

 findById(id: any): Observable<Ticket> {
    return this.http.get<Ticket>(`http://localhost:8080/ticket/${id}`);
 }
 
  findAll(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`http://localhost:8080/ticket`);
  }

  create(ticket: Ticket): Observable<Ticket> {
    return this.http.post<Ticket>(`http://localhost:8080/ticket`, ticket);
  }

  update(ticket: Ticket): Observable<Ticket> {
    return this.http.put<Ticket>(`http://localhost:8080/ticket/${ticket.id}`, ticket);
  }
}
