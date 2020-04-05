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
		System.out.println(username);
		if (user.getId()==-1) {
			this.userdto = null;
			return false;
		}
		else {
			this.userdto=user;
			System.out.println(user);
			return true;
		}
	}
	
	public void deconnexion() {
		this.userdto=null;
	}
}
