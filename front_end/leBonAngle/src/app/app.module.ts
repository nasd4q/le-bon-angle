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
import { AddPhotoComponent } from './add-photo/add-photo.component';
import { AddCategorieComponent } from './add-categorie/add-categorie.component';
import { AddAuteurComponent } from './add-auteur/add-auteur.component';

@NgModule({
  declarations: [
    AppComponent,
    ListAnnoncesComponent,
    AnnonceComponent,
    AuteurComponent,
    AddAnnonceComponent,
    AddPhotoComponent,
    AddCategorieComponent,
    AddAuteurComponent
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
