package com.cinema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cinema.dto.SalleDto;
import com.cinema.dto.UserDto;

public class UserDAO extends CinemaDAO <UserDto> {
	@Override
	public List<UserDto> findAll() {
		
		//Création d'une liste des utilisateurs vide
		List<UserDto> users = new ArrayList<UserDto>();
		try {
			//Requete vers la base de données pour récupérer la liste des utilisateurs
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,nom,prenom,dateN,adresse,mdp,email from user");
			
			//Exécution de la requête et récupération du résultats
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			while (result.next()) {
				int id = result.getInt(1);
				String nom = result.getString(2);
				String prenom = result.getString(3);
				String dateN = result.getString(4);
				String adresse = result.getString(5);
				String mdp = result.getString(6);
				String email = result.getString(7);
				
				//Création d'un utilisateur
				UserDto user = new UserDto(id,nom,prenom,dateN,adresse,mdp,email);
			
				//Ajout de l'utilisateur à la liste des utilisateurs qui seront retrournés 
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public UserDto findById(int id) {
		UserDto user=new UserDto();
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,nom,prenom,dateN,adresse,mdp,email from user where id=?");
			st.setInt(1, id);
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			result.next();
			String nom = result.getString(2);
			String prenom = result.getString(3);
			String dateN = result.getString(4);
			String adresse = result.getString(5);
			String mdp = result.getString(6);
			String email = result.getString(7);
		
				
			//Création d'un utilisateur
			user.setId(id);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setDate(dateN);
			user.setAdresse(adresse);
			user.setMdp(mdp);
			user.setMail(email);
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean save(UserDto obj) {
		try {
			PreparedStatement st;
			if (obj.getId()==-1) {
				st =CinemaDAO.cn.prepareStatement("insert into user (nom,prenom,dateN,adresse,mdp,email) values (?,?,?,?,?,?)");
			}
			else {
				st =CinemaDAO.cn.prepareStatement("insert into user (nom,prenom,dateN,adresse,mdp,email,id) values (?,?,?,?,?,?,?)");
				st.setInt(7, obj.getId());
			}
			st.setString(1, obj.getNom());
			st.setString(2, obj.getPrenom());
			st.setString(3, obj.getDate());
			st.setString(4, obj.getAdresse());
			st.setString(5, obj.getMdp());
			st.setString(6, obj.getMail());
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
			PreparedStatement st =CinemaDAO.cn.prepareStatement("delete from user where id=?");
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
	public boolean update(int id,UserDto obj) {
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("update user set id=?,nom=?,prenom=?,dateN=?,adresse=?,mdp=?,email=? where id=?");
			UserDto use= this.findById(id);
			
			if(obj.getId()==-1)
				st.setInt(1, use.getId());
			else
				st.setInt(1, obj.getId());
			
			
			if(obj.getNom()==null)
				st.setString(2, use.getNom());
			else 
				st.setString(2, obj.getNom());
			
			
			if(obj.getPrenom()==null)
				st.setString(3, use.getPrenom());
			else 
				st.setString(3, obj.getPrenom());
			
			
			if(obj.getDate()==null)
				st.setString(4, use.getDate());
			else 
				st.setString(4, obj.getDate());
			
			
			if(obj.getAdresse()==null)
				st.setString(5, use.getAdresse());
			else 
				st.setString(5, obj.getAdresse());
			
			if(obj.getMdp()==null)
				st.setString(6, use.getMdp());
			else 
				st.setString(6, obj.getMdp());
			
			
			if(obj.getMail()==null)
				st.setString(7, use.getMail());
			else 
				st.setString(7, obj.getMail());
			
			st.setInt(8, id);
			
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public UserDto seConnecter(String utilisateur,String mdp) {
		UserDto user=new UserDto();
		try {
			
			PreparedStatement st =CinemaDAO.cn.prepareStatement("select id,nom,prenom,dateN,adresse,email from user where mdp=? and email=?");
			st.setString(1, mdp);
			st.setString(2, utilisateur);
			ResultSet result = st.executeQuery();
			result.next();
			int id = result.getInt(1);
			String nom = result.getString(2);
			String prenom=result.getString(3);
			String date=result.getString(4);
			String adresse=result.getString(5);
			String email=result.getString(6);
			
			user.setId(id);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setDate(date);
			user.setAdresse(adresse);
			user.setMdp(mdp);
			user.setMail(email);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	
}
