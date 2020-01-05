import { Component, ViewChild } from '@angular/core';
import { Annonce } from 'src/model/annonce';
import { ListAnnoncesComponent } from './list-annonces/list-annonces.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'leBonAngle';
  annonceToShow: Annonce = null;
  addingNewAnnonce: boolean = false;
  @ViewChild(ListAnnoncesComponent, {static: true})
  private list: ListAnnoncesComponent;

  refresh(value:boolean) {
    console.log(value);
    this.list.refresh();
  }
}
