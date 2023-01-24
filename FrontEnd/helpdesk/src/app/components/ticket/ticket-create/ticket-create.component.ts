import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { Suporte } from 'src/app/models/suporte';
import { Ticket } from 'src/app/models/ticket';
import { ClienteService } from 'src/app/services/cliente.service';
import { SuporteService } from 'src/app/services/suporte.service';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket-create',
  templateUrl: './ticket-create.component.html',
  styleUrls: ['./ticket-create.component.css']
})
export class TicketCreateComponent implements OnInit {

  ticket: Ticket = {
    prioridade: '',
    status: '',
    titulo: '',
    observacoes: '',
    suporte: '',
    cliente: '',
    nomeTecnico: '',
    nomeCliente: ''
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
    private ticketService: TicketService, private router: Router) { }

  ngOnInit(): void {
    this.findAllClientes();
    this.findAllSuporte();
  }

  create(): void{
    this.ticketService.create(this.ticket).subscribe((resposta) => {
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

}
