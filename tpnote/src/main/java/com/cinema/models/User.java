package com.cinema.models;

import com.cinema.dao.UserDAO;
import com.cinema.dto.UserDto;

public class User {
	
	private UserDAO dao = new UserDAO();
	private UserDto userdto = null;
	
	private static User user = null;
	
	public static User getInstance() {
		if(User.user==null) 
			User.user = new User();
		return User.user;
	}
	
	public boolean isConnected() {
		if(userdto==null)
			return false;
		return true;
	}
	
	public int getUserId() {
		if(userdto==null)
			return -1;
		else
			return userdto.getId();
	}
	
	public String getNom() {
		if(userdto==null)
			return null;
		else 
			return userdto.getNom();
	}
	
	public String getPrenom() {
		if(userdto==null)
			return null;
		else
			return userdto.getPrenom();
	}
	
	public boolean connexion(String username,String password) {
		UserDto user = dao.seConnecter(username, password);
		if (user.getId()==-1) {
			this.userdto = null;
			return false;
		}
		else {
			this.userdto=user;
			return true;
		}
	}
	
	public void deconnexion() {
		this.userdto=null;
	}
	
	public boolean creerCompte(String nom,String prenom,String daten,String email,String mdp,String adresse) {
		UserDto user = new UserDto();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setDate(daten);
		user.setMail(email);
		user.setMdp(mdp);
		user.setAdresse(adresse);
		
		if ( dao.save(user)) {
			this.userdto=dao.seConnecter(email, mdp);
			return true;
		}
		
		return false;
	}
}
