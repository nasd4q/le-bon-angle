import { Categorie } from './categorie';
import { Utilisateur } from './utilisateur';

export class Annonce {
  public photosUrl: string[] = [];

  constructor(
    public titre: string,
    public description: string,
    public prix: number,
    public dateDeCreation: Date,
    public lieu: string,
    public auteur: Utilisateur,
    public categorie: Categorie,
    public id: string) {
    }
}
