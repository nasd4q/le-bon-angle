import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Annonce } from 'src/model/annonce';
import { DataService } from 'src/service/data.service';

@Component({
  selector: 'app-list-annonces',
  templateUrl: './list-annonces.component.html',
  styleUrls: ['./list-annonces.component.scss']
})
export class ListAnnoncesComponent implements OnInit {
  allAnnonces: Annonce[];
  annonces: Annonce[];

  @Output() annonceClicked = new EventEmitter();

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.loadAnnonces();
  }

  loadAnnonces() {
    this.dataService.getAnnonces().then(
      annonces => {
        this.allAnnonces = annonces;
        this.annonces = this.allAnnonces;
        this.annonces.forEach(a =>
          this.dataService.getPhotosURLForAnnonce(a).then(urls => {
            a.photosUrl = urls;
          }));
      }
    );
  }
}
