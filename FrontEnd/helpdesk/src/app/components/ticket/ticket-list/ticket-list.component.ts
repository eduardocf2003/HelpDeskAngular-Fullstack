import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Ticket } from 'src/app/models/ticket';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {

  ELEMENT_DATA: Ticket[] = [{
    id: 1,
    prioridade: 'ALTA',
    status: 'ABERTO',
    titulo: 'Problema com o computador',
    dataAbertura: '21/06/2021',
    dataFechamento: '22/06/2021',
    descricao: 'O computador não liga',
    suporte: 1,
    cliente: 1,
    nomeCliente: 'João da Silva',
    nomeTecnico: 'José da Silva',
  }];

  displayedColumns: string[] = ['id', 'titulo', 'cliente', 'suporte', 'dataAbertura', 'prioridade', 'status', 'acoes'];
  dataSource = new MatTableDataSource<Ticket>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor() { }

  ngOnInit(): void {
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
