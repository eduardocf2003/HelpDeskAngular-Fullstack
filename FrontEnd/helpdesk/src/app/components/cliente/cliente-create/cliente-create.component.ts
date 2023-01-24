import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrls: ['./cliente-create.component.css']
})
export class ClienteCreateComponent implements OnInit {

  cliente: Cliente = {
    nome: '',
    email: '',
    telefone: '',
    senha: '',
    cpf: '',
    perfis: [],
    dataCriacao: ''
  }

  nome: FormControl = new FormControl(null, Validators.minLength(3));
  email: FormControl = new FormControl(null, [Validators.required, Validators.email]);
  telefone: FormControl = new FormControl(null, Validators.required);
  senha: FormControl = new FormControl(null, Validators.required);
  cpf: FormControl = new FormControl(null, Validators.required);
  
  constructor(
    private service: ClienteService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  

  create(): void {
    this.service.create(this.cliente).subscribe(() => {
      console.log('Cliente criado com sucesso!');
      this.router.navigate(['clientes']);
    }, ex => {
      console.log('Erro ao criar cliente!');
    }) 
  
  
    }

    addPerfil(perfil: any): void {

      if(this.cliente.perfis.includes(perfil)) {
        this.cliente.perfis.splice(this.cliente.perfis.indexOf(perfil), 1);
        console.log(this.cliente.perfis);
      } else {
        this.cliente.perfis.push(perfil);
        console.log(this.cliente.perfis);
      }
    }

    validarCampos(): boolean {
      return this.nome.valid && this.email.valid && this.telefone.valid && this.senha.valid && this.cpf.valid;
    }



}
