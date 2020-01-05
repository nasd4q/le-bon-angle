import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Annonce } from 'src/model/annonce';
import { DataService } from 'src/service/data.service';
import { Categorie } from 'src/model/categorie';

@Component({
  selector: 'app-list-annonces',
  templateUrl: './list-annonces.component.html',
  styleUrls: ['./list-annonces.component.scss']
})
export class ListAnnoncesComponent implements OnInit {
  allAnnonces: Annonce[];
  annonces: Annonce[];
  categories: Categorie[];

  @Output() annonceClicked = new EventEmitter();
  @Output() newAnnonceClicked = new EventEmitter();

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.loadAnnonces();
    this.loadCategories();
  }

  refresh() {
    this.loadAnnonces();
    this.loadCategories();
  }

  loadAnnonces() {
    this.dataService.getAnnonces().then(
      annonces => {
        this.allAnnonces = annonces;
        this.annonces = this.allAnnonces;
        this.annonces.forEach(a =>
          this.dataService.getPhotosURLForAnnonce(a).then(urls => {
            a.photosUrl = urls; }));
      }
    );
  }

  loadCategories() {
    this.dataService.getCategories().then(
      categories => {
        this.categories = categories;
      }
    );
  }

  onCategorieChosen(id: string) {
    console.log('chosen :' + id);
    if (id === 'all') {
      this.annonces = this.allAnnonces;
    } else {
    this.annonces = this.allAnnonces.filter(a => a.categorie.id === id);
    }
  }

  onSearchChanged(texteRecherche: string) {
    this.annonces = this.allAnnonces.filter(a =>
      a.auteur.pseudo.includes(texteRecherche) ||
      a.categorie.nom.includes(texteRecherche) ||
      a.description.includes(texteRecherche) ||
      a.titre.includes(texteRecherche) ||
      a.lieu.includes(texteRecherche));
  }
}
