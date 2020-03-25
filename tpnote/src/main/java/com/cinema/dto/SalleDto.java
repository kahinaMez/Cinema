package com.cinema.dto;

public class SalleDto {
	private int id;
	private int nb_place;
	
	public SalleDto() {
		super();
	}

	public SalleDto(int id, int nb_place) {
		super();
		this.id = id;
		this.nb_place = nb_place;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNb_place() {
		return nb_place;
	}

	public void setNb_place(int nb_place) {
		this.nb_place = nb_place;
	}
	
	

}
