import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Credenciais } from 'src/app/models/credenciais';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  creds: Credenciais = {
    email: '',
    senha: ''
  }

  email = new FormControl(null, Validators.email);
  senha = new FormControl(null, Validators.minLength(4));

  constructor(private service: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  

  fazerLogin() {
    this.service.authenticate(this.creds).subscribe(resposta => {
      this.service.sucessfulLogin(resposta.headers.get('Authorization'));
      this.router.navigate(['']);
    },
    error => {});
  }

  validarCampos(): boolean {
    return this.email.valid && this.senha.valid;
  }
  

}
