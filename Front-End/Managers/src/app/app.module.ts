import { CreateDependente } from './create-dependete/create-dependente.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSocioComponent } from './create-socio/create-socio.component';
import { SocioListComponent } from './socio-list/socio-list.component';
import { UpdateSocioComponent } from './update-socio/update-socio.component';
import { HttpClientModule } from '@angular/common/http';
import { DependenteListComponent } from './dependente-list/dependente-list.component';
import { DepedenteDetailsComponent } from './dependente-details/dependente-details.component';
import { UpdateDepedenteComponent } from './update-dependente/update-dependente.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateSocioComponent,
    SocioListComponent,
    UpdateSocioComponent,
    CreateDependente,
    DependenteListComponent,
    DepedenteDetailsComponent,
    UpdateDepedenteComponent,
    CreateDependente
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent,
    CreateSocioComponent,
    SocioListComponent,
    UpdateSocioComponent,
    CreateDependente,
    DependenteListComponent,
    DepedenteDetailsComponent,
    UpdateDepedenteComponent]
})
export class AppModule { }
