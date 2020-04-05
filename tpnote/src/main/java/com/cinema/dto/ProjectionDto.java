package com.cinema.dto;

public class ProjectionDto {

	private int id=-1;
	private String date=null;
	private int nb_place_libre=-1;
	private double tarif=-1;
	private int id_film = -1;
	private int id_salle  = -1;
	
	
	public ProjectionDto() {
		super();
	}
	
	public ProjectionDto(int id, String date, int nb_place_libre, double tarif,int id_film,int id_salle) {
		super();
		this.id = id;
		this.date = date;
		this.nb_place_libre = nb_place_libre;
		this.tarif = tarif;
		this.id_film=id_film;
		this.id_salle=id_salle;
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

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	
	public int getId_film() {
		return id_film;
	}

	public void setId_film(int id_film) {
		this.id_film = id_film;
	}

	public int getId_salle() {
		return id_salle;
	}

	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}

	@Override
	public String toString() {
		return "ProjectionDto [id=" + id + ", date=" + date + ", nb_place_libre=" + nb_place_libre + ", tarif=" + tarif
				+ "]";
	}
	
	

}
