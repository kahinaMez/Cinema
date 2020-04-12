package com.cinema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cinema.dto.ProjectionDto;

public class ProjectionDAO extends CinemaDAO<ProjectionDto> {
	@Override
	public List<ProjectionDto> findAll() {
		
		//Création d'une liste de projections vide
		List<ProjectionDto> projections = new ArrayList<ProjectionDto>();
		try {
			//Requete vers la base de données pour récupérer la liste des projections
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,date,nb_place_libre,tarif,id_film,id_salle from projection");
			
			//Exécution de la requête et récupération du résultats
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			while (result.next()) {
				int id = result.getInt(1);
				String date = result.getString(2);
				int nb_place_libre = result.getInt(3);
				double tarif = result.getDouble(4);
				int id_film = result.getInt(5);
				int id_salle = result.getInt(6);
				//Création d'un acteur
				ProjectionDto projection = new ProjectionDto(id,date,nb_place_libre,tarif,id_film,id_salle);
			
				//Ajout de l'acteur à la liste des acteurs qui sera retrournée 
				projections.add(projection);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projections;
	}

	@Override
	public ProjectionDto findById(int id) {
		ProjectionDto projection=new ProjectionDto();
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,date,nb_place_libre,tarif,id_film,id_salle from projection where id=?");
			st.setInt(1, id);
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			if(result.next()){
				String date = result.getString(2);
				int nb_place_libre= result.getInt(3);
				double tarif = result.getDouble(4);
				int id_film = result.getInt(5);
				int id_salle = result.getInt(6);
					
				//Création d'une projection
				projection.setId(id);
				projection.setDate(date);
				projection.setNb_place_libre(nb_place_libre);
				projection.setTarif(tarif);
				projection.setId_film(id_film);
				projection.setId_salle(id_salle);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return projection;
	}

	@Override
	public boolean save(ProjectionDto obj) {
		try {
			PreparedStatement st;
			if (obj.getId()==-1) {
				st =CinemaDAO.cn.prepareStatement("insert into projection (date,nb_place_libre,tarif,id_film,id_salle) values (?,?,?,?,?)");
			}
			else {
				st =CinemaDAO.cn.prepareStatement("insert into projection (date,nb_place_libre,tarif,id_film,id_salle,id) values (?,?,?,?,?,?)");
				st.setInt(6, obj.getId());
			}
			st.setString(1, obj.getDate());
			st.setInt(2, obj.getNb_place_libre());
			st.setDouble(3, obj.getTarif());
			st.setInt(4,obj.getId_film());
			st.setInt(5, obj.getId_salle());
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
	public boolean delete(int id) {
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("delete from projection where id=?");
			st.setInt(1, id);
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean update(int id,ProjectionDto obj) {
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("update projection set id=?,date=?,nb_place_libre=?,tarif=?,id_film=?,id_salle=? where id=?");
			ProjectionDto pro= this.findById(id);
			
			if(obj.getId()==-1)
				st.setInt(1, pro.getId());
			else
				st.setInt(1, obj.getId());
			
			
			if(obj.getDate()==null)
				st.setString(2, pro.getDate());
			else 
				st.setString(2, obj.getDate());
			
			
			if(obj.getNb_place_libre()==-1)
				st.setInt(3, pro.getNb_place_libre());
			else 
				st.setInt(3, obj.getNb_place_libre());
			
			
			if(obj.getTarif()==-1)
				st.setDouble(4, pro.getTarif());
			else 
				st.setDouble(4, obj.getTarif());
			
			if(obj.getId_film()==-1)
				st.setInt(5, pro.getId_film());
			else 
				st.setInt(5, obj.getId_film());;
			
			if(obj.getId_film()==-1)
				st.setInt(6, pro.getId_salle());
			else 
				st.setInt(6, obj.getId_salle());
			
			st.setInt(7, id);
			
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


}
