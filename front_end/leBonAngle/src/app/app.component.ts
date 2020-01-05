import { Component } from '@angular/core';
import { Annonce } from 'src/model/annonce';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'leBonAngle';
  annonceToShow: Annonce = null;
  addingNewAnnonce: boolean = false;
}
