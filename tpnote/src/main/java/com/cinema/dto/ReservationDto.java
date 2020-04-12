package com.cinema.dto;

public class ReservationDto {
	private int id_user = -1;
	private int id_projection = -1;
	private int n_reservation = -1;
	private boolean validation = false;
	private String dateReservation = null;
	
	public ReservationDto() {
		super();
	}

	public ReservationDto(int id_user, int id_projection, int n_reservation,String dateReservation, boolean validation) {
		super();
		this.id_user = id_user;
		this.id_projection = id_projection;
		this.n_reservation = n_reservation;
		this.validation = validation;
		this.dateReservation = dateReservation;
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

	public String getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}
	
}
