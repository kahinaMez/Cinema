package com.cinema.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cinema.models.User;
import com.cinema.utils.FxDialogs;
import com.cinema.utils.Scenes;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class InscriptionController {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@FXML private JFXTextField nom;
	@FXML private JFXTextField prenom;
	@FXML private JFXDatePicker daten;
	@FXML private JFXTextField email;
	@FXML private JFXPasswordField mdp;	
	@FXML private JFXPasswordField mdp2;	
	@FXML private JFXTextField adresse;
	
	@FXML
	public void valider(ActionEvent event) {
		User userModel = User.getInstance();
		
		if(checkNomPrenom(nom) && checkNomPrenom(prenom) && checkDateNaissance() 
				&& checkMail() && checkPassword() && checkMdpMdp2() ) {
			
			boolean rep=userModel.creerCompte(nom.getText(), prenom.getText(), daten.getValue().toString(),
					email.getText(),mdp.getText(), adresse.getText());
			if(rep) {
				FxDialogs.showInformation("Succès", "Votre compte a bien été créé");
				Scenes sc = Scenes.getInstance();
				sc.switchToProjectionsScene();
			}
			else {
				FxDialogs.showError("Erreur", "Erreur lors de la création du compte");
			}	
		}
		else {
			FxDialogs.showError("Erreur", "Vérifier les champs ");
		}
	}
	
	@FXML
	public void seConnecter(ActionEvent event) {
		Scenes sc = Scenes.getInstance();
		sc.switchToLoginScene();
	}
	
	private boolean checkNomPrenom(JFXTextField champs) {
		if(champs==null) return false;
		if(champs.getText().length()>1) 
			return true;
		return false;
	}
	
	private boolean checkPassword() {
		if(mdp==null) return false;
		if(mdp.getText().length()>7)
			return true;
		return false;
	}
	
	private boolean checkMdpMdp2() {
		if(mdp==null || mdp2==null) return false;
		if(mdp.getText().equals(mdp2.getText()))
			return true;
		return false;
	}
	
	private boolean checkMail() {
		if(email==null) return false;
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email.getText());
        return matcher.find();
	}
	
	private boolean checkDateNaissance() {
		if(daten==null) return false;
		daten.getValue();
		if(daten.getValue()!=null) {
			if(daten.getValue().toString().length()>0)
				return true;
		}
		return false;
	}
	
	
}
