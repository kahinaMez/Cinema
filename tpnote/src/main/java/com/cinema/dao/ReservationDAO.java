package com.cinema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cinema.dto.ReservationDto;

public class ReservationDAO extends CinemaDAO<ReservationDto>{

	@Override
	public List<ReservationDto> findAll() {
		List<ReservationDto> reservations = new ArrayList<ReservationDto>();
		try {
			PreparedStatement st= cn.prepareStatement("select (n_reservation,id_user,id_projection,date_reservation,validation) from reservation");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int n_reservation = result.getInt(1);
				int id_user = result.getInt(2);
				int id_projection = result.getInt(3);
				String  dateReservation = result.getString(4);
				boolean validation = result.getBoolean(5);
				
				ReservationDto reservation = new ReservationDto(id_user, id_projection, n_reservation, dateReservation, validation);
				reservations.add(reservation);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public ReservationDto findById(int id) {
		ReservationDto reservation = new ReservationDto();
		try {
			PreparedStatement st= cn.prepareStatement("select n_reservation,id_user,id_projection,date_reservation,validation from reservation where n_reservation=?");
			st.setInt(1, id);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int n_reservation = result.getInt(1);
				int id_user = result.getInt(2);
				int id_projection = result.getInt(3);
				String  dateReservation = result.getString(4);
				boolean validation = result.getBoolean(5);
				
				reservation.setN_reservation(n_reservation);
				reservation.setId_user(id_user);
				reservation.setId_projection(id_projection);
				reservation.setDateReservation(dateReservation);
				reservation.setValidation(validation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservation;
	}

	@Override
	public boolean save(ReservationDto obj) {
		try {
			PreparedStatement st;
			if(obj.getN_reservation()==-1) {
				st = cn.prepareStatement("insert into reservation(id_user,id_projection,date_reservation,validation) values(?,?,?,?)");
			}
			else {
				st = cn.prepareStatement("insert into reservation(id_user,id_projection,date_reservation,validation,n_reservation) values(?,?,?,?,?)");
				st.setInt(5, obj.getN_reservation());
			} 
			
			st.setInt(1, obj.getId_user());
			st.setInt(2, obj.getId_projection());
			st.setString(3, obj.getDateReservation());
			st.setBoolean(4, obj.isValidation());
			
			if(st.executeUpdate()==1) 
				return true;
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			PreparedStatement st = cn.prepareStatement("delete from reservation where n_reservation =?");
			st.setInt(1,id);
			
			if(st.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(int id, ReservationDto obj) {
		try {
			PreparedStatement st = cn.prepareStatement("UPDATE reservation set n_reservation=?,id_user=?,id_projection=?,"
					+ "date_reservation=?,validation=? where n_reservation=?");
			ReservationDto current = this.findById(id);
			
			if(obj.getN_reservation()==-1)
				st.setInt(1, current.getN_reservation());
			else
				st.setInt(1, obj.getN_reservation());
			
			if(obj.getId_user()==-1)
				st.setInt(2, current.getId_user());
			else
				st.setInt(2, obj.getId_user());
			
			if(obj.getId_projection()==-1)
				st.setInt(3, current.getId_projection());
			else
				st.setInt(3, obj.getId_projection());
			
			if(obj.getDateReservation()==null)
				st.setString(4, current.getDateReservation());
			else
				st.setString(4, obj.getDateReservation());
			
			st.setBoolean(5, obj.isValidation());
			st.setInt(6, id);
			
			if(st.executeUpdate()==1)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
