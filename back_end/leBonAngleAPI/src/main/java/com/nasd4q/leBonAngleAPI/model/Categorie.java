package com.nasd4q.leBonAngleAPI.model;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/* 
model class pour notre API pour l'objet utilisateur
champs : id, pseudo,  telephone, email
*/


@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @Type(type="uuid-binary")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @GeneratedValue(generator="uuid2")
    @Column(columnDefinition="BINARY(16)", unique=true, updatable=false)
    private final UUID id = UUID.randomUUID();
    private String nom;

    public Categorie() {
        super();
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public UUID getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
}