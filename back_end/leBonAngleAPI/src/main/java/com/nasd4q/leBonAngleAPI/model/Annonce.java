package com.nasd4q.leBonAngleAPI.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
    @Type(type="uuid-binary")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @GeneratedValue(generator="uuid2")
    @Column(columnDefinition="BINARY(16)", unique=true, updatable=false)
    private final UUID id = UUID.randomUUID();
    private String titre;
    private String description;
    @Column(precision = 11, scale = 2)    
    private BigDecimal prix;
    @Temporal(TemporalType.TIMESTAMP)
    private final Date dateDeCreation = new Date();
    private String lieu;
    @ManyToOne
    private Utilisateur auteur;
    @ManyToOne
    private Categorie categorie;
    @OneToMany( targetEntity=Photo.class )
    private List photos;

    public Annonce() {
        super();
    }

    public Annonce(String titre, String description, BigDecimal prix, String lieu, Utilisateur auteur,
            Categorie categorie, List photos) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.lieu = lieu;
        this.auteur = auteur;
        this.categorie = categorie;
        this.photos = photos;
    }

    public UUID getId() {
        return id;
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

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List getPhotos() {
        return photos;
    }

    public void setPhotos(List photos) {
        this.photos = photos;
    }
    
}