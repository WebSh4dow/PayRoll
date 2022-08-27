import { DepedenteDetailsComponent } from './dependente-details/dependente-details.component';
import { UpdateDepedenteComponent } from './update-dependente/update-dependente.component';
import { CreateDependente } from './create-dependete/create-dependente.component';
import { DependenteListComponent } from './dependente-list/dependente-list.component';
import { SocioDetailsComponent } from './socio-details/socio-details.component';
import { UpdateSocioComponent } from './update-socio/update-socio.component';
import { CreateSocioComponent } from './create-socio/create-socio.component';
import { SocioListComponent } from './socio-list/socio-list.component';
import { Socio } from './socio';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'socios', component: SocioListComponent},
  {path: 'dependentes',component:DependenteListComponent},
  {path: 'create-dependente',component:CreateDependente},
  {path: 'update-dependetes/:id', component: UpdateDepedenteComponent},
  {path: 'dependentes-details/:id',component:DepedenteDetailsComponent},
  {path: 'create-socio', component: CreateSocioComponent},
  {path: '', redirectTo: 'socios', pathMatch: 'full'},
  {path: 'update-socios/:id', component: UpdateSocioComponent},
  {path: 'socios-details/:id', component: SocioDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
