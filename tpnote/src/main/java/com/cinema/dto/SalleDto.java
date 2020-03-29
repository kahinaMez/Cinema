package com.cinema.dto;

public class SalleDto {
	private int n_salle=-1;
	private int nb_place=-1;
	
	public SalleDto() {
		super();
	}

	public SalleDto(int n_salle, int nb_place) {
		super();
		this.n_salle = n_salle;
		this.nb_place = nb_place;
	}

	@Override
	public String toString() {
		return "SalleDto [n_salle=" + n_salle + ", nb_place=" + nb_place + "]";
	}

	public int getN_salle() {
		return n_salle;
	}

	public void setN_salle(int n_salle) {
		this.n_salle = n_salle;
	}

	public int getNb_place() {
		return nb_place;
	}

	public void setNb_place(int nb_place) {
		this.nb_place = nb_place;
	}
	
	

}
