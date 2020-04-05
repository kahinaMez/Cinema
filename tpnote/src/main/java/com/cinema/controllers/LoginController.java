package com.cinema.controllers;

import com.cinema.models.User;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

	public class LoginController {
		@FXML
		private TextField email;
		@FXML
		private PasswordField mdp;
		
		private User model = User.getInstance();
	
	@FXML
	public void seConnecter() {
		boolean success = model.connexion(email.getText(), mdp.getText());
		
		if(success)
			System.out.println("Welcome "+model.getNom()+ " "+model.getPrenom());
		else
			System.out.println("Wrong ");
	}
	
	

}
