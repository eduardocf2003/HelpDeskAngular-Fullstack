import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Suporte } from 'src/app/models/suporte';
import { SuporteService } from 'src/app/services/suporte.service';

@Component({
  selector: 'app-suporte-delete',
  templateUrl: './suporte-delete.component.html',
  styleUrls: ['./suporte-delete.component.css']
})
export class SuporteDeleteComponent implements OnInit {

  
  suporte: Suporte = {
    nome: '',
    email: '',
    telefone: '',
    senha: '',
    cpf: '',
    perfis: [],
    dataCriacao: ''
  }

  
  
  constructor(
    private service: SuporteService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.suporte.id = this.route.snapshot.paramMap.get('id');
    this.findById();
  }

  findById(): void {
    this.service.findById(this.suporte.id).subscribe((resposta) => {
      this.suporte = resposta;
    })
  }

  

  delete(): void {
    this.service.delete(this.suporte.id).subscribe(() => {
      console.log('Suporte atualizado com sucesso!');
      this.router.navigate(['suporte']);
    }, ex => {
      console.log('Erro ao atualizar suporte!');
    }) 
  
  
    }




}