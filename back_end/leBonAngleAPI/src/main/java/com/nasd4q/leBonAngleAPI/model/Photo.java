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
@Table(name = "photos")
public class Photo {
    @Id
    @Type(type="uuid-binary")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @GeneratedValue(generator="uuid2")
    @Column(columnDefinition="BINARY(16)", unique=true, updatable=false)
    private final UUID id = UUID.randomUUID();
    private String titre;
    @Lob
    private byte[] image;

    public Photo() {
        super();
    }

    public Photo(String titre, byte[] image) {
        this.titre = titre;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    
    
}