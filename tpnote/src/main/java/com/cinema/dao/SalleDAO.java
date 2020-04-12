package com.cinema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cinema.dto.SalleDto;

public class SalleDAO extends CinemaDAO <SalleDto>{
	@Override
	public List<SalleDto> findAll() {
		
		//Création d'une liste de salle vide
		List<SalleDto> projections = new ArrayList<SalleDto>();
		try {
			//Requete vers la base de données pour récupérer la liste des salles
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select n_salle,nb_place from salle");
			
			//Exécution de la requête et récupération du résultats
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			while (result.next()) {
				int n_salle = result.getInt(1);
				int nb_place = result.getInt(2);
				
				
				//Création d'une salle
				SalleDto salle = new SalleDto(n_salle,nb_place);
			
				//Ajout de la salle à la liste des salles qui sera retrournée 
				projections.add(salle);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projections;
	}

	@Override
	public SalleDto findById(int id) {
		SalleDto salle=new SalleDto();
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select n_salle,nb_place from salle where n_salle=?");
			st.setInt(1, id);
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			if(result.next()) {
				int nb_place= result.getInt(2);
				int n_salle=result.getInt(1);
				
					
				//Création d'une salle
				salle.setN_salle(n_salle);
				salle.setNb_place(nb_place);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return salle;
	}

	@Override
	public boolean save(SalleDto obj) {
		try {
			PreparedStatement st;
			if (obj.getN_salle()==-1) {
				st =CinemaDAO.cn.prepareStatement("insert into salle (nb_place) values (?)");
			}
			else {
				st =CinemaDAO.cn.prepareStatement("insert into salle (nb_place,n_salle) values (?,?)");
				st.setInt(2, obj.getN_salle());
			}
			st.setInt(1, obj.getNb_place());
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean delete(int n_salle) {
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("delete from salle where n_salle=?");
			st.setInt(1, n_salle);
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean update(int n_salle,SalleDto obj){
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("update salle set n_salle=?,nb_place=? where n_salle=?");
			SalleDto sal= this.findById(n_salle);
			
			if(obj.getN_salle()==-1)
				st.setInt(1, sal.getN_salle());
			else
				st.setInt(1, obj.getN_salle());
				
			if(obj.getNb_place()==-1)
				st.setInt(2, sal.getNb_place());
			else 
				st.setInt(2, obj.getNb_place());
			
			st.setInt(3,n_salle);
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


}
