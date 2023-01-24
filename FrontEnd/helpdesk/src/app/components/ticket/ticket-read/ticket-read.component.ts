import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Ticket } from 'src/app/models/ticket';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket-read',
  templateUrl: './ticket-read.component.html',
  styleUrls: ['./ticket-read.component.css']
})
export class TicketReadComponent implements OnInit {

  ticket: Ticket = {
    prioridade: '',
    status: '',
    titulo: '',
    observacoes: '',
    suporte: '',
    cliente: '',
    nomeTec: '',
    nomeCli: ''
  }
  
  
  
  constructor(private ticketService: TicketService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.ticket.id = this.route.snapshot.paramMap.get('id');
    this.findById(this.ticket.id);
  }

  findById(id: string): void{
    this.ticketService.findById(id).subscribe((resposta) => {
      this.ticket = resposta;
    })
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

}
