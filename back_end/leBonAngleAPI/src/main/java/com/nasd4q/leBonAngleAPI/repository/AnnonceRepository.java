package com.nasd4q.leBonAngleAPI.repository;

import com.nasd4q.leBonAngleAPI.model.Annonce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
}