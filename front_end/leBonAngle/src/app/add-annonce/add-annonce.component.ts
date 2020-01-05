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
    this.loadCategories();
    this.loadAuteurs();
  }

  loadCategories() {
    this.dataService.getCategories().then(
      categories => {
        this.categories = categories;
      }
    );
  }

  loadAuteurs() {
    this.dataService.getUtilisateurs().then(
      utilisateurs => {
        this.auteurs = utilisateurs;
      }
    );
  }

  posterAnnonce() {
    this.dataService.addAnnonce(this.model)
    .then(resObj => {
      console.log(JSON.stringify(resObj));
      this.backToList.emit(true); });
  }

  categorieOnChange(event) {
    if (event.target.value.includes("NEW") {
      this.itemCreated = "Categorie"
    }
  }
}
