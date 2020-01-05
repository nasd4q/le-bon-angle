import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Categorie } from 'src/model/categorie';
import { Annonce } from 'src/model/annonce';
import { Utilisateur } from 'src/model/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  protected url = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  getCategories(): Promise<Categorie[]> {
    return this.http.get<any[]>(this.url + '/categories')
    .toPromise()
    .then(
      (value) => value.map(c => new Categorie(c.nom, c.id))
    );
  }

  getAnnonces(): Promise<Annonce[]> {
    return this.http.get<any[]>(this.url + '/annonces')
    .toPromise()
    .then(
      (value) => value.map(a => new Annonce(
        a.titre,
        a.description,
        a.prix,
        new Date(a.dateDeCreation),
        a.lieu,
        new Utilisateur(a.auteur.pseudo, a.auteur.telephone, a.auteur.email, a.auteur.id),
        new Categorie(a.categorie.nom, a.categorie.id),
        a.id
      ))
    );
  }

  postAnnonce(a : Annonce): Promise<Annonce> {}
}
