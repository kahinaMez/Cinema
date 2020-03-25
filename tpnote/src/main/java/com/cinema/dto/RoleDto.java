package com.cinema.dto;

public class RoleDto{
	private int id_acteur;
	private int id_film;
	private String nom;
	
	public RoleDto() {};
	
	public RoleDto(int id_acteur, int id_film, String nom) {
		super();
		this.id_acteur = id_acteur;
		this.id_film = id_film;
		this.nom = nom;
	}

	public int getId_acteur() {
		return id_acteur;
	}

	public void setId_acteur(int id_acteur) {
		this.id_acteur = id_acteur;
	}

	public int getId_film() {
		return id_film;
	}

	public void setId_film(int id_film) {
		this.id_film = id_film;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
