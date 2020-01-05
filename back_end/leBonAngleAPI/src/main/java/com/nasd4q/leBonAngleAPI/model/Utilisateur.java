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
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @Type(type="uuid-binary")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @GeneratedValue(generator="uuid2")
    @Column(columnDefinition="BINARY(16)", unique=true, updatable=false)
    private final UUID id = UUID.randomUUID();
    private String pseudo;
    private String telephone;
    private String email;

    public Utilisateur() {
        super();
    }

    public Utilisateur(String pseudo, String telephone, String email) {
        this.pseudo = pseudo;
        this.telephone = telephone;
        this.email = email;
    }

	public UUID getId() {
		return id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}