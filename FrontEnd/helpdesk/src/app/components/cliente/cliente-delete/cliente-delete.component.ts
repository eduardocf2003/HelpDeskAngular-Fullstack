import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-delete',
  templateUrl: './cliente-delete.component.html',
  styleUrls: ['./cliente-delete.component.css']
})
export class ClienteDeleteComponent implements OnInit {

  
  cliente: Cliente = {
    nome: '',
    email: '',
    telefone: '',
    senha: '',
    cpf: '',
    perfis: [],
    dataCriacao: ''
  }

  
  
  constructor(
    private service: ClienteService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.cliente.id = this.route.snapshot.paramMap.get('id');
    this.findById();
  }

  findById(): void {
    this.service.findById(this.cliente.id).subscribe((resposta) => {
      this.cliente = resposta;
    })
  }

  

  delete(): void {
    this.service.delete(this.cliente.id).subscribe(() => {
      console.log('Cliente atualizado com sucesso!');
      this.router.navigate(['clientes']);
    }, ex => {
      console.log('Erro ao atualizar cliente!');
    }) 
  
  
    }




}