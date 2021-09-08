package com.http.tp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Formation {
private long id;
@NotBlank
private String titre;
@Column(nullable = true,length = 100)
private String description;
@Column(unique = true,length=30)
private String formateur;
@NotNull
private int duree;
public long getId() {
	return id;
}
public void setId(long id) {
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
public String getFormateur() {
	return formateur;
}
public void setFormateur(String formateur) {
	this.formateur = formateur;
}
public int getDuree() {
	return duree;
}
public void setDuree(int duree) {
	this.duree = duree;
}



}
