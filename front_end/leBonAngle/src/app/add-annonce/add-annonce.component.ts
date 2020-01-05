import { Component, OnInit } from '@angular/core';
import { Categorie } from 'src/model/categorie';
import { Utilisateur } from 'src/model/utilisateur';
import { DataService } from 'src/service/data.service';

@Component({
  selector: 'app-add-annonce',
  templateUrl: './add-annonce.component.html',
  styleUrls: ['./add-annonce.component.scss']
})
export class AddAnnonceComponent implements OnInit {
  categories: Categorie[];
  auteurs: Utilisateur[];

  constructor(private dataService: DataService) { }

  ngOnInit() {
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
