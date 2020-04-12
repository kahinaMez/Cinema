package com.cinema.models;

import java.sql.Date;
import java.util.Calendar;

import com.cinema.dao.ProjectionDAO;
import com.cinema.dao.ReservationDAO;
import com.cinema.dto.ProjectionDto;
import com.cinema.dto.ReservationDto;

public class Reservation {
	
	private static Reservation payement=null;
	
	private ReservationDAO dao ;
	private ReservationDto reservation;
	private double prix;
	
	private Reservation() {
		dao=new ReservationDAO();
		reservation = new ReservationDto();
	}
	
	public static Reservation getInstance() {
		if(payement==null) {
			payement = new Reservation();
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
		
		if(dao.save(reservation)) {
			ProjectionDAO pjDao = new ProjectionDAO();
			
			int idProjection = reservation.getId_projection();
			ProjectionDto toUpdate = pjDao.findById(idProjection);
			toUpdate.setNb_place_libre(toUpdate.getNb_place_libre()-1);
			
			return pjDao.update(idProjection, toUpdate);
		}
		
		return false;
		
	}
	
	
	
}
