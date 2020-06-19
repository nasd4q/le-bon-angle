package com.nasd4q.leBonAngleAPI.repository;

import java.util.List;
import java.util.UUID;

import com.nasd4q.leBonAngleAPI.model.Annonce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, UUID> {
    List<Annonce> findByCategorie_Id(UUID categorieID);
    List<Annonce> findByAuteur_Id(UUID auteurId);
}