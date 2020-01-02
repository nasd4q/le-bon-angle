package com.nasd4q.leBonAngleAPI.controller;

import com.nasd4q.leBonAngleAPI.repository.CategorieRepository;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.nasd4q.leBonAngleAPI.model.Categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository;

    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @PostMapping("/categories")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @GetMapping("/categories/{id}")
    public Categorie getCategorieById(@PathVariable(value = "id") UUID categorieId) throws Exception {
        return categorieRepository.findById(categorieId)
                .orElseThrow(() -> new Exception("Categorie Not found for id " + categorieId));
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable(value = "id") UUID categorieId) throws Exception {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new Exception("Categorie Not found for id " + categorieId));

        categorieRepository.delete(categorie);

        return ResponseEntity.ok().build();
    }
}