package com.nasd4q.leBonAngleAPI.controller;

import com.nasd4q.leBonAngleAPI.repository.AnnonceRepository;
import com.nasd4q.leBonAngleAPI.repository.CategorieRepository;
import com.nasd4q.leBonAngleAPI.repository.PhotoRepository;
import com.nasd4q.leBonAngleAPI.repository.UtilisateurRepository;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.nasd4q.leBonAngleAPI.exception.ResourceNotFoundException;
import com.nasd4q.leBonAngleAPI.model.Annonce;
import com.nasd4q.leBonAngleAPI.model.Categorie;
import com.nasd4q.leBonAngleAPI.model.Photo;
import com.nasd4q.leBonAngleAPI.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AnnonceController {

    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    PhotoRepository photoRepository;


    @GetMapping("/annonces")
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @PostMapping("/annonces")
    public Annonce createAnnonce(@Valid @RequestBody Annonce annonce, 
    @RequestParam("auteurId") UUID auteurID, @RequestParam("categorieId") UUID categorieId) 
    throws ResourceNotFoundException{
        Utilisateur auteur = utilisateurRepository.findById(auteurID).orElseThrow(
            () -> new ResourceNotFoundException("No utilisateur found with id : " + auteurID.toString()));
        Categorie categorie = categorieRepository.findById(categorieId).orElseThrow(
            () -> new ResourceNotFoundException("No categorie found with id : " + categorieId.toString()));
            annonce.setAuteur(auteur);
            annonce.setCategorie(categorie);
        return annonceRepository.save(annonce);
    }

    @GetMapping("/annonces/{id}")
    public Annonce getAnnonceById(@PathVariable(value = "id") UUID annonceId) throws Exception {
        return annonceRepository.findById(annonceId)
                .orElseThrow(() -> new Exception("Annonce Not found for id " + annonceId));
    }

    @GetMapping("/annoncesFromAuteur/{id}")
    public List<Annonce> getAnnonceFromAuteur(@PathVariable(value = "id") UUID auteurId) throws Exception {
        return annonceRepository.findByAuteur_Id(auteurId);
    }

    @GetMapping("/annoncesFromCategorie/{id}")
    public List<Annonce> getAnnonceFromCategorie(@PathVariable(value = "id") UUID categorieId) throws Exception {
        return annonceRepository.findByCategorie_Id(categorieId);
    }

    // @PutMapping("/annonces/{id}")
    // public Annonce updateAnnonce(@PathVariable(value = "id") UUID annonceId, @Valid @RequestBody Annonce annonceDetails)
    //         throws Exception {
    //     Annonce annonce = annonceRepository.findById(annonceId)
    //             .orElseThrow(() -> new Exception("Annonce Not found for id " + annonceId));
    //     annonce.setDescription(annonceDetails.getDescription());
    //     annonce.setPrix(annonceDetails.getPrix());
    //     annonce.setTitre(annonceDetails.getTitre());
    //     Annonce updatedAnnonce = annonceRepository.save(annonce);
    //     return updatedAnnonce;
    // }

    @DeleteMapping("/annonces/{id}")
    public ResponseEntity<?> deleteAnnonce(@PathVariable(value = "id") UUID annonceId) throws Exception {
        Annonce annonce = annonceRepository.findById(annonceId)
                .orElseThrow(() -> new Exception("Annonce Not found for id " + annonceId));

        List<Photo> photos = photoRepository.findByAnnonce_Id(annonceId);
        for (Photo p : photos) {
            photoRepository.delete(p);
        }

        annonceRepository.delete(annonce);

        return ResponseEntity.ok().build();
    }
}