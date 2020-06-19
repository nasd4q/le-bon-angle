import { Component, OnInit, Input } from '@angular/core';
import { Utilisateur } from 'src/model/utilisateur';
import { DataService } from 'src/service/data.service';

@Component({
  selector: 'app-auteur',
  templateUrl: './auteur.component.html',
  styleUrls: ['./auteur.component.scss']
})
export class AuteurComponent implements OnInit {
  @Input() auteur: Utilisateur;

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}
