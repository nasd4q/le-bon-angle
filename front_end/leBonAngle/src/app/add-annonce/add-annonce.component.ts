import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Categorie } from 'src/model/categorie';
import { Utilisateur } from 'src/model/utilisateur';
import { DataService } from 'src/service/data.service';
import { Annonce } from 'src/model/annonce';

@Component({
  selector: 'app-add-annonce',
  templateUrl: './add-annonce.component.html',
  styleUrls: ['./add-annonce.component.scss']
})
export class AddAnnonceComponent implements OnInit {
  categories: Categorie[];
  auteurs: Utilisateur[];
  model: Annonce = new Annonce('','', 0, null,'', null, null,'');
  itemCreated: string = "Annonce";

  @Output() backToList = new EventEmitter();


  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.loadCategories(true);
    this.loadAuteurs(true);
  }

  loadCategories(doIt : boolean) {
    if (doIt) {
    this.dataService.getCategories().then(
      categories => {
        this.categories = categories;
      }
    );
    }
  }

  loadAuteurs(doIt : boolean) {
    if (doIt) {
    this.dataService.getUtilisateurs().then(
      utilisateurs => {
        this.auteurs = utilisateurs;
      }
    );
    }
  }

  posterAnnonce() {
    this.dataService.addAnnonce(this.model)
    .then(resObj => {
      console.log(JSON.stringify(resObj));
      this.backToList.emit(true); });
  }

  categorieOnChange(event) {
    if (event.target.value.includes("NEW")) {
      this.itemCreated = "Categorie";
      setTimeout(()=> this.model.categorie = null,500);
    }

  }

  onBackFromAddCategorie(event) {
    this.itemCreated = "Annonce";
    if (event) {
      setTimeout(this.loadCategories,500);
    }
  }

  auteurOnChange(event) {
    if (event.target.value.includes("NEW")) {
      this.itemCreated = "Auteur";
      setTimeout(()=> this.model.auteur = null,500);
    }
  }

  onBackFromAddAuteur(event) {
    this.itemCreated = "Annonce";
    if (event) {
      setTimeout(this.loadAuteurs,500);
    }
  }
}
