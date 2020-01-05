import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { DataService } from 'src/service/data.service';
import { ListAnnoncesComponent } from './list-annonces/list-annonces.component';
import { AnnonceComponent } from './annonce/annonce.component';
import { AuteurComponent } from './auteur/auteur.component';
import { AddAnnonceComponent } from './add-annonce/add-annonce.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ListAnnoncesComponent,
    AnnonceComponent,
    AuteurComponent,
    AddAnnonceComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
