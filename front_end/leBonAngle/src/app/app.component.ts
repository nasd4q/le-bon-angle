import { Component, ViewChild, AfterViewInit } from '@angular/core';
import { Annonce } from 'src/model/annonce';
import { ListAnnoncesComponent } from './list-annonces/list-annonces.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
  title = 'leBonAngle';
  annonceToShow: Annonce = null;
  addingNewAnnonce = false;
  @ViewChild('list', {static : false})
  private listC: ListAnnoncesComponent;

  ngAfterViewInit(): void {
  }

  refresh(value: boolean) {
    if (value) {
      console.log('refreshing list...');
      setTimeout(()=>this.listC.refresh(),300);
    }
  }
}
