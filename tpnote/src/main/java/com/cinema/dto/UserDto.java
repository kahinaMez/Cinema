package com.cinema.dto;

import java.sql.Date;

public class UserDto {
	private int id;
	private String nom;
	private String prenom;
	private Date date;
	private String adresse;
	private String mdp;
	private String mail;
	
	public UserDto() {}
	
	public UserDto(int id, String nom, String prenom, Date date, String adresse, String mdp, String mail) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
