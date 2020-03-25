package com.cinema.dto;

import java.sql.Date;

public class FilmDto {
	private int id;
	private String nom;
	private Date date_sortie;
	private String genre;
	
	public FilmDto() {};
	public FilmDto(int id, String nom, Date date_sortie, String genre) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_sortie = date_sortie;
		this.genre = genre;
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
	public Date getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	} 
	
	
	

}
