import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Annonce } from 'src/model/annonce';
import { DataService } from 'src/service/data.service';

@Component({
  selector: 'app-annonce',
  templateUrl: './annonce.component.html',
  styleUrls: ['./annonce.component.scss']
})
export class AnnonceComponent implements OnInit {
  @Input() annonce: Annonce;
  @Output() backClicked = new EventEmitter();

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

  deleteAnnonce() {
    this.dataService.deleteAnnonce(this.annonce);
    this.backClicked.emit(true);
  }

}
