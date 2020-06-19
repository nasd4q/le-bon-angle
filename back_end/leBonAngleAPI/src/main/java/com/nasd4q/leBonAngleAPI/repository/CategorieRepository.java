package com.nasd4q.leBonAngleAPI.repository;

import java.util.UUID;

import com.nasd4q.leBonAngleAPI.model.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, UUID> {
}