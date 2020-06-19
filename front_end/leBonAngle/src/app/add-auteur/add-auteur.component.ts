import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Utilisateur } from 'src/model/utilisateur';
import { DataService } from 'src/service/data.service';

@Component({
  selector: 'app-add-auteur',
  templateUrl: './add-auteur.component.html',
  styleUrls: ['./add-auteur.component.scss']
})
export class AddAuteurComponent implements OnInit {
  @Output() backToAddAnnonce = new EventEmitter();

  modeleAuteur: Utilisateur = new Utilisateur("", "", "", "");

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

  posterAuteur() {
    this.dataService.addUtilisateur(this.modeleAuteur).then(
      resObj => console.log(JSON.stringify(resObj))
    );
    this.backToAddAnnonce.emit(true);
  }
}
