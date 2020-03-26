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
		
		//Cr�ation d'une liste d'acteurs vide
		List<ActeurDto> acteurs = new ArrayList<ActeurDto>();
		try {
			//Requete vers la base de donn�es pour r�cup�rer la liste des acteurs
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,nom,prenom,dateN from acteur");
			
			//Ex�cution de la requ�te et r�cup�ration du r�sultats
			ResultSet result = st.executeQuery();
			
			//Parcrous du r�sultat
			while (result.next()) {
				int id = result.getInt(1);
				String nom = result.getString(2);
				String prenom = result.getString(3);
				String dateNaissance = result.getString(4);
				
				//Cr�ation d'un acteur
				ActeurDto acteur = new ActeurDto(id,nom,prenom,dateNaissance);
				
				//Ajout de l'acteur � la liste des acteurs qui sera retrourn�e 
				acteurs.add(acteur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acteurs;
	}

	@Override
	public ActeurDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(ActeurDto obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ActeurDto obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
