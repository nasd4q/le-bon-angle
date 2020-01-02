package com.nasd4q.leBonAngleAPI.repository;

import java.util.UUID;

import com.nasd4q.leBonAngleAPI.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, UUID> {
}