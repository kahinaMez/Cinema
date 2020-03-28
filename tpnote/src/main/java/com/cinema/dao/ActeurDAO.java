package com.cinema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cinema.dto.ActeurDto;

public class ActeurDAO extends CinemaDAO<ActeurDto>{

	@Override
	public List<ActeurDto> findAll() {
		
		//Création d'une liste d'acteurs vide
		List<ActeurDto> acteurs = new ArrayList<ActeurDto>();
		try {
			//Requete vers la base de données pour récupérer la liste des acteurs
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,nom,prenom,dateN from acteur");
			
			//Exécution de la requête et récupération du résultats
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			while (result.next()) {
				int id = result.getInt(1);
				String nom = result.getString(2);
				String prenom = result.getString(3);
				String dateNaissance = result.getString(4);
				
				//Création d'un acteur
				ActeurDto acteur = new ActeurDto(id,nom,prenom,dateNaissance);
				
				//Ajout de l'acteur à la liste des acteurs qui sera retrournée 
				acteurs.add(acteur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acteurs;
	}

	@Override
	public ActeurDto findById(int id) {
		ActeurDto acteur=new ActeurDto();
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,nom,prenom,dateN from acteur where id=?");
			st.setInt(1, id);
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			result.next();
			String nom = result.getString(2);
			String prenom = result.getString(3);
			String dateNaissance = result.getString(4);
				
			//Création d'un acteur
			acteur.setId(id);
			acteur.setNom(nom);
			acteur.setPrenom(prenom);
			acteur.setDate_naissance(dateNaissance);
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return acteur;
	}

	@Override
	public boolean save(ActeurDto obj) {
		try {
			PreparedStatement st;
			if (obj.getId()==-1) {
				st =CinemaDAO.cn.prepareStatement("insert into acteur (nom,prenom,dateN) values (?,?,?)");
			}
			else {
				st =CinemaDAO.cn.prepareStatement("insert into acteur (nom,prenom,dateN,id) values (?,?,?,?)");
				st.setInt(4, obj.getId());
			}
			st.setString(1, obj.getNom());
			st.setString(2, obj.getPrenom());
			st.setString(3, obj.getDate_naissance());
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
			PreparedStatement st =CinemaDAO.cn.prepareStatement("delete from acteur where id=?");
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
	public boolean update(int id,ActeurDto obj) {
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("update acteur set id=?,nom=?,prenom=?,dateN=? where id=?");
			ActeurDto act= this.findById(id);
			
			if(obj.getId()==-1)
				st.setInt(1, act.getId());
			else
				st.setInt(1, obj.getId());
			
			
			if(obj.getNom()==null)
				st.setString(2, act.getNom());
			else 
				st.setString(2, obj.getNom());
			
			
			if(obj.getPrenom()==null)
				st.setString(3, act.getPrenom());
			else 
				st.setString(3, obj.getPrenom());
			
			
			if(obj.getDate_naissance()==null)
				st.setString(4, act.getDate_naissance());
			else 
				st.setString(4, obj.getDate_naissance());
			
			st.setInt(5, id);
			
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
}
