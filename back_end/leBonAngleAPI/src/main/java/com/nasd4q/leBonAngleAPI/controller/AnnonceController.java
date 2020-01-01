package com.nasd4q.leBonAngleAPI.controller;

import com.nasd4q.leBonAngleAPI.repository.AnnonceRepository;

import java.util.List;

import javax.validation.Valid;

import com.nasd4q.leBonAngleAPI.model.Annonce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnnonceController {

    @Autowired
    AnnonceRepository annonceRepository;

    @GetMapping("/annonces")
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @PostMapping("/annonces")
    public Annonce createAnnonce(@Valid @RequestBody Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @GetMapping("/annonces/{id}")
    public Annonce getAnnonceById(@PathVariable(value = "id") Long annonceId) throws Exception {
        return annonceRepository.findById(annonceId)
                .orElseThrow(() -> new Exception("Annonce Not found for id " + annonceId));
    }

    @PutMapping("/annonces/{id}")
    public Annonce updateAnnonce(@PathVariable(value = "id") Long annonceId, @Valid @RequestBody Annonce annonceDetails)
            throws Exception {
        Annonce annonce = annonceRepository.findById(annonceId)
                .orElseThrow(() -> new Exception("Annonce Not found for id " + annonceId));
        annonce.setDescription(annonceDetails.getDescription());
        annonce.setPrix(annonceDetails.getPrix());
        annonce.setTitre(annonceDetails.getTitre());
        Annonce updatedAnnonce = annonceRepository.save(annonce);
        return updatedAnnonce;
    }

    @DeleteMapping("/annonces/{id}")
    public ResponseEntity<?> deleteAnnonce(@PathVariable(value = "id") Long annonceId) throws Exception {
        Annonce annonce = annonceRepository.findById(annonceId)
                .orElseThrow(() -> new Exception("Annonce Not found for id " + annonceId));

        annonceRepository.delete(annonce);

        return ResponseEntity.ok().build();
    }
}