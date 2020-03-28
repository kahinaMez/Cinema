package com.cinema.dto;

public class ActeurDto {

	private int id=-1;
	private String nom=null;
	private String prenom=null;
	private String date_naissance=null;
	
	public ActeurDto() {};
	
	public ActeurDto(int id, String nom, String prenom, String date_naissance) {
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

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	} 
	
	@Override
	public String toString() {
		return "ActeurDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance
				+ "]";
	}
}
