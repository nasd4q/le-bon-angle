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

  file: File = null;

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

  posterPhoto() {
    console.log(this.file.size);
    this.dataService.addPhoto(this.annonce, this.file.name, this.file)
    .then(resObj=>{console.log(resObj); this.backToAnnonce.emit(true);});
  }

  onChange(event) {
    const files : FileList = event.srcElement.files;
    this.file = files[0];
    console.log(this.file.name);
  }

}
