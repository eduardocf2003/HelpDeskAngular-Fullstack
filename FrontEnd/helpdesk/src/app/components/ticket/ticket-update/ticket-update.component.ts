import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { Suporte } from 'src/app/models/suporte';
import { Ticket } from 'src/app/models/ticket';
import { ClienteService } from 'src/app/services/cliente.service';
import { SuporteService } from 'src/app/services/suporte.service';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket-update',
  templateUrl: './ticket-update.component.html',
  styleUrls: ['./ticket-update.component.css']
})
export class TicketUpdateComponent implements OnInit {

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
  
  clientes: Cliente[] = [] 
  suporte: Suporte[] = []
  
  prioridade: FormControl = new FormControl(null, [Validators.required]);
  status: FormControl = new FormControl(null, [Validators.required]);
  titulo: FormControl = new FormControl(null, [Validators.required]);
  observacoes: FormControl = new FormControl(null, [Validators.required]);
  tecnico: FormControl = new FormControl(null, [Validators.required]);
  cliente: FormControl = new FormControl(null, [Validators.required]);
  
  constructor(private clienteService: ClienteService, private suporteService: SuporteService,
    private ticketService: TicketService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.ticket.id = this.route.snapshot.paramMap.get('id');
    this.findById(this.ticket.id);
    this.findAllClientes();
    this.findAllSuporte();
  }

  findById(id: string): void{
    this.ticketService.findById(id).subscribe((resposta) => {
      this.ticket = resposta;
    })
  }
  
  update(): void{
    this.ticketService.update(this.ticket).subscribe((resposta) => {
      this.ticket = resposta;
      console.log(this.ticket);
      this.router.navigate(['ticket']);
    })
  }
  
  findAllClientes(): void{
    this.clienteService.findAll().subscribe((resposta) => {
      this.clientes = resposta;
    })
  }

  findAllSuporte(): void{
    this.suporteService.findAll().subscribe((resposta) => {
      this.suporte = resposta;
    })
  }
  
  validaCampos(): boolean{
    return this.prioridade.valid && this.status.valid && this.titulo.valid && this.observacoes.valid && this.tecnico.valid && this.cliente.valid;
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
