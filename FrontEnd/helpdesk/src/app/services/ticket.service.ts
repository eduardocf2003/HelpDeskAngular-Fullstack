import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from '../models/ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http: HttpClient) { }

 findAll(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`http://localhost:8080/ticket`);
  }
}
