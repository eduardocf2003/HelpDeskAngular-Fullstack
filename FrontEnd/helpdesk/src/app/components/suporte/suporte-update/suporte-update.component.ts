import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Suporte } from 'src/app/models/suporte';
import { SuporteService } from 'src/app/services/suporte.service';

@Component({
  selector: 'app-suporte-update',
  templateUrl: './suporte-update.component.html',
  styleUrls: ['./suporte-update.component.css']
})
export class SuporteUpdateComponent implements OnInit {

  
  suporte: Suporte = {
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

  

  update(): void {
    this.service.update(this.suporte).subscribe(() => {
      console.log('Suporte atualizado com sucesso!');
      this.router.navigate(['suporte']);
    }, ex => {
      console.log('Erro ao atualizar suporte!');
    }) 
  
  
    }

    addPerfil(perfil: any): void {

      if(this.suporte.perfis.includes(perfil)) {
        this.suporte.perfis.splice(this.suporte.perfis.indexOf(perfil), 1);
        console.log(this.suporte.perfis);
      } else {
        this.suporte.perfis.push(perfil);
        console.log(this.suporte.perfis);
      }
    }

    validarCampos(): boolean {
      return this.nome.valid && this.email.valid && this.telefone.valid && this.senha.valid && this.cpf.valid;
    }



}
