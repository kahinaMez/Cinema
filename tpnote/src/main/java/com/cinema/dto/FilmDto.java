package com.cinema.dto;

public class FilmDto {
	private int id=-1;
	private String titre=null;
	private String date_sortie=null;
	private String genre=null;
	
	public FilmDto() {};
	public FilmDto(int id, String titre, String date_sortie, String genre) {
		super();
		this.id = id;
		this.titre = titre;
		this.date_sortie = date_sortie;
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(String date_sortie) {
		this.date_sortie = date_sortie;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "FilmDto [id=" + id + ", titre=" + titre + ", date_sortie=" + date_sortie + ", genre=" + genre + "]";
	} 
	
	
	

}
