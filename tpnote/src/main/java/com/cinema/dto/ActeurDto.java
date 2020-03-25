package com.cinema.dto;

import java.sql.Date;

public class ActeurDto {
	private int id;
	private String nom;
	private String prenom;
	private Date date_naissance;
	
	public ActeurDto() {};
	
	public ActeurDto(int id, String nom, String prenom, Date date_naissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	} 
	

}
