package com.nasd4q.leBonAngleAPI.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/* 
model class pour notre API pour l'objet annonce
champs ... à venir !! ... : id, titre,  description, prix, 
date, lieu, 
auteur(ID), catégorie(ID), photos(???)
*/

@Entity
@Table(name = "annonces")
public class Annonce {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String titre;
    @NotBlank
    private String description;
    private int prix;

    public Annonce() {
        super();
    }

    public Annonce(Long id, @NotBlank String titre, @NotBlank String description, @NotBlank int prix) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


}