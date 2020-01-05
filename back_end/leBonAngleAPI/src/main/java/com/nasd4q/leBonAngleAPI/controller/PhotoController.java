package com.nasd4q.leBonAngleAPI.controller;

import com.nasd4q.leBonAngleAPI.repository.AnnonceRepository;
import com.nasd4q.leBonAngleAPI.repository.PhotoRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import com.nasd4q.leBonAngleAPI.exception.ResourceNotFoundException;
import com.nasd4q.leBonAngleAPI.model.Annonce;
import com.nasd4q.leBonAngleAPI.model.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PhotoController {

    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    AnnonceRepository annonceRepository;

    @GetMapping("/photos")
    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    @PostMapping("/photos")
    public Photo createPhoto(@RequestParam("titre") String titre, 
    @RequestParam("file") MultipartFile file, @RequestParam("annonceId") UUID annonceId) 
    throws IOException{
        Annonce annonce = annonceRepository.findById(annonceId).orElseThrow(()->
            new ResourceNotFoundException("no annonce found with id " + annonceId.toString()));

        Photo photo = new Photo(titre, file.getBytes(), annonce);
        return photoRepository.save(photo);
    }

    @GetMapping(value = "/photos/{id}",
                produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getPhotoById(@PathVariable(value = "id") UUID photoId) throws Exception {
        Photo photo = photoRepository.findById(photoId).orElseThrow(
            () -> new ResourceNotFoundException("No photos with id : " + photoId.toString()));
        return photo.getImage();
    }

    @GetMapping("/photosIdForAnnonce/{id}")
    public List<UUID> getPhotosIdForAnnonce(@PathVariable(value = "id") UUID annonceId) throws Exception {
        List<Photo> photos = photoRepository.findByAnnonce_Id(annonceId);
        List<UUID> photosIds = new ArrayList<>();
            for (Photo p : photos)
        {
            photosIds.add(p.getId());
        }
        return photosIds;
    }

    @DeleteMapping("/photos/{id}")
    public ResponseEntity<?> deletePhoto(@PathVariable(value = "id") UUID photoId) throws Exception {
        Photo photo = photoRepository.findById(photoId)
                .orElseThrow(() -> new Exception("Photo Not found for id " + photoId));

        photoRepository.delete(photo);

        return ResponseEntity.ok().build();
    }
}