import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { ListaSuporteComponent } from './components/suporte/lista-suporte/lista-suporte.component';
import { SuporteCreateComponent } from './components/suporte/suporte-create/suporte-create.component';
import { SuporteUpdateComponent } from './components/suporte/suporte-update/suporte-update.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: '', component: NavComponent, canActivate: [AuthGuard], children: [
      {path: 'home', component: HomeComponent},
      
      {path: 'suporte', component: ListaSuporteComponent},
      {path: 'suporte/create', component: SuporteCreateComponent},
      {path: 'suporte/update', component: SuporteUpdateComponent}

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
