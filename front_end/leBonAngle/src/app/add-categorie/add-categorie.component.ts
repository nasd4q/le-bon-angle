import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { DataService } from 'src/service/data.service';
import { Categorie } from 'src/model/categorie';

@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.scss']
})
export class AddCategorieComponent implements OnInit {
  @Output() backToAddAnnonce = new EventEmitter();

  modeleCategorie: Categorie = new Categorie("", "");

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

  posterCategorie() {
    this.dataService.addCategorie(this.modeleCategorie).then(
      resObj => console.log(JSON.stringify(resObj))
    );
    this.backToAddAnnonce.emit(true);
  }

}
