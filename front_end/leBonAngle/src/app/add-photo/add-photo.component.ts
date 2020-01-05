import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { DataService } from 'src/service/data.service';
import { Annonce } from 'src/model/annonce';

@Component({
  selector: 'app-add-photo',
  templateUrl: './add-photo.component.html',
  styleUrls: ['./add-photo.component.scss']
})
export class AddPhotoComponent implements OnInit {
  @Output() backToAnnonce = new EventEmitter();
  @Input() annonce : Annonce;

  modelPhoto = {titre : "", file: null};

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

  posterPhoto() {
    this.dataService.addPhoto(this.annonce, this.modelPhoto.titre, this.modelPhoto.file)
    .then(resObj=>console.log(resObj));
  }

}
