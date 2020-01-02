package com.nasd4q.leBonAngleAPI.repository;

import java.util.UUID;

import com.nasd4q.leBonAngleAPI.model.Photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, UUID> {
}