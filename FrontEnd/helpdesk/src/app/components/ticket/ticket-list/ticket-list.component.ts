import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Ticket } from 'src/app/models/ticket';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {

  ELEMENT_DATA: Ticket[] = []
  FILTERED_DATA: Ticket[] = []

  displayedColumns: string[] = ['id', 'titulo', 'cliente', 'suporte', 'dataAbertura', 'prioridade', 'status', 'acoes'];
  dataSource = new MatTableDataSource<Ticket>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private service: TicketService) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void{
    this.service.findAll().subscribe((resposta) => {
      this.ELEMENT_DATA = resposta;
      this.dataSource = new MatTableDataSource<Ticket>(this.ELEMENT_DATA);
      this.dataSource.paginator = this.paginator;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  retornaStatus(status: any): string{
    if(status == 0){
      return "Aberto";
    } else if(status == 1){
      return "Em andamento";
    } else {
      return "Finalizado";
    }
  }

  retornaPrioridade(prioridade: any): string{
    if(prioridade == 0){
      return "Baixa";
    } else if(prioridade == 1){
      return "Média";
    } else {
      return "Alta";
    }
  }

  orderByStatus(status: any): void{
    let list: Ticket[] = [];
    this.ELEMENT_DATA.forEach(element => {
      if(element.status == status){
        list.push(element)
      }
    });
    this.FILTERED_DATA = list;
    this.dataSource = new MatTableDataSource<Ticket>(this.FILTERED_DATA);
    this.dataSource.paginator = this.paginator;
  }

}
