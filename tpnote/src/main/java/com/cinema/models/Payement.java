package com.cinema.models;

import java.sql.Date;
import java.util.Calendar;

import com.cinema.dao.ReservationDAO;
import com.cinema.dto.ReservationDto;

public class Payement {
	
	private static Payement payement=null;
	
	private ReservationDAO dao ;
	private ReservationDto reservation;
	private double prix;
	
	private Payement() {
		dao=new ReservationDAO();
		reservation = new ReservationDto();
	}
	
	public static Payement getInstance() {
		if(payement==null) {
			payement = new Payement();
		}
		return payement;
	}
	
	public void setProjection(int idProjection) {
		reservation.setId_projection(idProjection);
	}
	
	public void setPrix(double prix) {
		this.prix=prix;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public void resetProjection() {
		reservation.setId_projection(-1);
	}
	
	public boolean reserver() {
		if(reservation.getId_projection()==-1)
			return false;
		
		User user = User.getInstance();
		int userId = user.getUserId();
		
		if(!user.isConnected())
			return false;
		
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		reservation.setDateReservation(date.toString());
		reservation.setValidation(true);
		reservation.setId_user(userId);
		
		return dao.save(reservation);
		
	}
	
	
	
}
