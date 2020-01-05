import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { DataService } from 'src/service/data.service';
import { ListAnnoncesComponent } from './list-annonces/list-annonces.component';
import { AnnonceComponent } from './annonce/annonce.component';
import { AuteurComponent } from './auteur/auteur.component';

@NgModule({
  declarations: [
    AppComponent,
    ListAnnoncesComponent,
    AnnonceComponent,
    AuteurComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
