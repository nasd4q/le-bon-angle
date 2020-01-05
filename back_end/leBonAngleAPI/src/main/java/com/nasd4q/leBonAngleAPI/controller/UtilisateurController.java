package com.nasd4q.leBonAngleAPI.controller;

import com.nasd4q.leBonAngleAPI.repository.UtilisateurRepository;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.nasd4q.leBonAngleAPI.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @PostMapping("/utilisateurs")
    public Utilisateur createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @GetMapping("/utilisateurs/{id}")
    public Utilisateur getUtilisateurById(@PathVariable(value = "id") UUID utilisateurId) throws Exception {
        return utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new Exception("Utilisateur Not found for id " + utilisateurId));
    }


    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable(value = "id") UUID utilisateurId) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new Exception("Utilisateur Not found for id " + utilisateurId));

        utilisateurRepository.delete(utilisateur);

        return ResponseEntity.ok().build();
    }
}