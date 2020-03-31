package com.cinema.controllers;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.cinema.dao.UserDAO;
import com.cinema.dto.UserDto;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;

public class InscriptionController {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@FXML
	private JFXTextField nom;
	
	@FXML
	private JFXTextField prenom;
	
	@FXML
	private JFXDatePicker daten;
	
	@FXML
	private JFXTextField email;
	
	@FXML
	private JFXPasswordField mdp;
	
	@FXML
	private JFXPasswordField mdp2;
	
	@FXML
	private JFXTextField adresse;
	
	@FXML
	public void valider() {
		UserDAO dao = new UserDAO ();
		
		if(checkNomPrenom(nom) && checkNomPrenom(prenom) && checkDateNaissance() 
				&& checkMail() && checkPassword() && checkMdpMdp2() ) {
			UserDto user = new UserDto();
			user.setNom(nom.getText());
			user.setPrenom(prenom.getText());
			user.setDate(daten.getValue().toString());
			user.setMail(email.getText());
			user.setMdp(mdp.getText());
			user.setAdresse(adresse.getText());
			
			//dao.save(user);
			JOptionPane.showMessageDialog(null, "Votre compte a bien été créé", "Succès", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Vérifier les champs ", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private boolean checkNomPrenom(JFXTextField champs) {
		if(champs.getText().length()>1) 
			return true;
		return false;
	}
	
	private boolean checkPassword() {
		if(mdp.getText().length()>7)
			return true;
		return false;
	}
	
	private boolean checkMdpMdp2() {
		if(mdp.getText().equals(mdp2.getText()))
			return true;
		return false;
	}
	
	private boolean checkMail() {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email.getText());
        return matcher.find();
	}
	
	private boolean checkDateNaissance() {
		if(daten.getValue().toString().length()>0)
			return true;
		return false;
	}
	
}
