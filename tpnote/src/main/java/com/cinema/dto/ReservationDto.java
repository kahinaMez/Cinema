package com.cinema.dto;

public class ReservationDto {
	private int id_user;
	private int id_projection;
	private int n_reservation;
	private boolean validation;
	
	public ReservationDto() {
		super();
	}

	public ReservationDto(int id_user, int id_projection, int n_reservation, boolean validation) {
		super();
		this.id_user = id_user;
		this.id_projection = id_projection;
		this.n_reservation = n_reservation;
		this.validation = validation;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_projection() {
		return id_projection;
	}

	public void setId_projection(int id_projection) {
		this.id_projection = id_projection;
	}

	public int getN_reservation() {
		return n_reservation;
	}

	public void setN_reservation(int n_reservation) {
		this.n_reservation = n_reservation;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	
	
	
	
	

}
