import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Categorie } from 'src/model/categorie';
import { Annonce } from 'src/model/annonce';
import { Utilisateur } from 'src/model/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  protected url = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

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

  addAnnonce(a: Annonce): Promise<any> {
    return this.http.post<any>(this.url + '/annonces'
    + '?auteurId=' + a.auteur.id + '&categorieId=' + a.categorie.id,
    {titre : a.titre, description: a.description, prix : a.prix, lieu : a.lieu, })
    .toPromise();
  }

  addUtilisateur(u: Utilisateur): Promise<boolean> {
    return this.http.post<any>(this.url + '/utilisateurs',
    {pseudo : u.pseudo, telephone: u.telephone, email: u.email })
    .toPromise()
    .then(returnedObj => returnedObj.id.length > 0);
  }

  addCategorie(c: Categorie): Promise<any> {
    return this.http.post<any>(this.url + '/categories',
    {nom : c.nom})
    .toPromise();
  }

  addPhoto(a: Annonce, titre: string, file: File): Promise<any> {
    const input = new FormData();
    input.append('titre', titre);
    input.append('file', file);
    input.append('annonceId', a.id);

    let hd = new HttpHeaders();
    hd = hd.append( 'Content-Type', 'multipart/form-data' );

    const req = new HttpRequest('POST', this.url + '/photos', input, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req).toPromise();
  }

  deleteAnnonce(a: Annonce) {
    console.log("deleting annonce id" + a.id);
    return this.http.delete(this.url + '/annonces/' + a.id).toPromise();
  }

  getPhotosURLForAnnonce(a: Annonce): Promise<string[]> {
    return this.http.get<any[]>(this.url + '/photosIdForAnnonce/' + a.id)
    .toPromise()
    .then(objs => objs.map(id => this.url + '/photos/' + id));
  }

  getCategories(): Promise<Categorie[]> {
    return this.http.get<any[]>(this.url + '/categories')
    .toPromise()
    .then(
      (value) => value.map(c => new Categorie(c.nom, c.id))
    );
  }

  getUtilisateurs(): Promise<Utilisateur[]> {
    return this.http.get<any[]>(this.url + '/utilisateurs')
    .toPromise()
    .then(
      (value) => value.map(u=> new Utilisateur(u.pseudo, u.telephone, u.email, u.id))
    );
  }
}
