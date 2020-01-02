package com.nasd4q.leBonAngleAPI.controller;

import com.nasd4q.leBonAngleAPI.repository.PhotoRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.nasd4q.leBonAngleAPI.exception.ResourceNotFoundException;
import com.nasd4q.leBonAngleAPI.model.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotoController {

    @Autowired
    PhotoRepository photoRepository;

    @GetMapping("/photos")
    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    @PostMapping("/photos")
    public Photo createPhoto(@RequestParam("titre") String titre, @RequestParam("file") MultipartFile file) 
    throws IOException{
        Photo photo = new Photo(titre, file.getBytes());

        return photoRepository.save(photo);
    }

    @GetMapping(value = "/photos/{id}",
                produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getPhotoById(@PathVariable(value = "id") UUID photoId) throws Exception {
        Photo photo = photoRepository.findById(photoId).orElseThrow(
            () -> new ResourceNotFoundException("No photos with id : " + photoId.toString()));
        return photo.getImage();
    }

    @DeleteMapping("/photos/{id}")
    public ResponseEntity<?> deletePhoto(@PathVariable(value = "id") UUID photoId) throws Exception {
        Photo photo = photoRepository.findById(photoId)
                .orElseThrow(() -> new Exception("Photo Not found for id " + photoId));

        photoRepository.delete(photo);

        return ResponseEntity.ok().build();
    }
}