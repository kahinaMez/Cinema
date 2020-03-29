package com.cinema.dto;

import java.sql.Date;

public class UserDto {
	private int id=-1;
	private String nom=null;
	private String prenom=null;
	private String date=null;
	private String adresse=null;
	private String mdp=null;
	private String mail=null;
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date=" + date + ", adresse=" + adresse
				+ ", mdp=" + mdp + ", mail=" + mail + "]";
	}

	public UserDto() {}
	
	public UserDto(int id, String nom, String prenom, String date, String adresse, String mdp, String mail) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.adresse = adresse;
		this.mdp = mdp;
		this.mail = mail;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
