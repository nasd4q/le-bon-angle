import { Component, OnInit, Output } from '@angular/core';
import { EventEmitter } from 'protractor';
import { DataService } from 'src/service/data.service';
import { Categorie } from 'src/model/categorie';
import { Utilisateur } from 'src/model/utilisateur';
import { Annonce } from 'src/model/annonce';

@Component({
  selector: 'app-add-annonce',
  templateUrl: './add-annonce.component.html',
  styleUrls: ['./add-annonce.component.scss']
})
export class AddAnnonceComponent implements OnInit {
  @Output() backToList = new EventEmitter();
  categories: Categorie[];
  auteurs: Utilisateur[];

  model = new Annonce("","",0,new Date(),"",null,null,"");

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.loadCategories();
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

}
