import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { ClienteCreateComponent } from './components/cliente/cliente-create/cliente-create.component';
import { ClienteDeleteComponent } from './components/cliente/cliente-delete/cliente-delete.component';
import { ListaClienteComponent } from './components/cliente/lista-cliente/lista-cliente.component';
import { ClienteUpdateComponent } from './components/cliente/cliente-update/cliente-update.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { ListaSuporteComponent } from './components/suporte/lista-suporte/lista-suporte.component';
import { SuporteCreateComponent } from './components/suporte/suporte-create/suporte-create.component';
import { SuporteDeleteComponent } from './components/suporte/suporte-delete/suporte-delete.component';
import { SuporteUpdateComponent } from './components/suporte/suporte-update/suporte-update.component';
import { TicketListComponent } from './components/ticket/ticket-list/ticket-list.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: '', component: NavComponent, canActivate: [AuthGuard], children: [
      {path: 'home', component: HomeComponent},
      
      {path: 'suporte', component: ListaSuporteComponent},
      {path: 'suporte/create', component: SuporteCreateComponent},
      {path: 'suporte/update/:id', component: SuporteUpdateComponent},
      {path: 'suporte/delete/:id', component: SuporteDeleteComponent},

      {path: 'clientes', component: ListaClienteComponent},
      {path: 'clientes/create', component: ClienteCreateComponent},
      {path: 'clientes/update/:id', component: ClienteUpdateComponent},
      {path: 'clientes/delete/:id', component: ClienteDeleteComponent},

      {path: 'ticket', component: TicketListComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
