package com.cinema.dto;

import java.sql.Date;

public class ProjectionDto {
	private int id;
	private String date;
	private int nb_place_libre;
	private float tarif;
	
	public ProjectionDto() {
		super();
	}
	
	public ProjectionDto(int id, String date, int nb_place_libre, float tarif) {
		super();
		this.id = id;
		this.date = date;
		this.nb_place_libre = nb_place_libre;
		this.tarif = tarif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNb_place_libre() {
		return nb_place_libre;
	}

	public void setNb_place_libre(int nb_place_libre) {
		this.nb_place_libre = nb_place_libre;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	
	
	
	

}
