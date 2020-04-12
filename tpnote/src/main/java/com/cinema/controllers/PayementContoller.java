package com.cinema.controllers;

import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.cinema.models.Reservation;
import com.cinema.utils.FxDialogs;
import com.cinema.utils.Scenes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PayementContoller implements Initializable{
	
	private static String DEVISE = "Euro";
	
	@FXML private TextField nom;
	@FXML private TextField numCarte;
	@FXML private DatePicker dateExpiration;
	@FXML private TextField cvc;
	@FXML private Label prix;
	
	private Reservation reservation ;
	private Scenes sc;
	
	public PayementContoller() {
		this.reservation = Reservation.getInstance();
		this.sc = Scenes.getInstance();
	}
	
	@FXML
	public void annuler() {
		Scenes sc = Scenes.getInstance();
		sc.switchToProjectionsScene();
	}
	
	@FXML
	public void valider() {
		String err = "";
		
		err+=checkCardName();
		err+=checkCardNumber();
		err+=checkCvc();
		err+=checkDateExpiration();
		
		if(err.length()==0) {
			boolean confirm = reservation.reserver();
			if(confirm) {
				FxDialogs.showInformation("Votre réservation a bien été effectuée : ","Merci d'avoir réservé sur CinemaCOSMOS");
				sc.switchToProjectionsScene();
			}
			else {
				FxDialogs.showError("Erreur lors de la réservation", "veuillez réessayer plus tard");
			}
		}
		else {
			FxDialogs.showError("Veuillez vérifier les champs suivants : ",err);
		}
	}
	
	public String checkCardName() {
		if(this.nom.getText().length()<2)
			return " - Le nom sur la carte ne doit pas être vide\n";
		else
			return "";
	}
	
	public String checkCardNumber() {
		try {
			Long.parseLong(this.numCarte.getText());
		}
		catch(NumberFormatException e) {
			return " - Le numéro de la carte doit etre constitué uniquement de nombres\n";
		}
		
		if(this.numCarte.getText().length()==16)
			return "";
		else
			return " - Le numéro de carte doit être constitué de 16 chiffres exactement\n";
	}
	
	public String checkCvc() {
		try {
			Long.parseLong(this.cvc.getText());
		}
		catch(NumberFormatException e) {
			return " - Le cvc doit etre constitué uniquement de nombres\n";
		}
		
		if(this.cvc.getText().length()==3)
			return "";
		else
			return " - Le numéro cvc doit être constitué de 3 chiffres exactement\n";
	}
	
	public String checkDateExpiration() {
		Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());

		if(this.dateExpiration.getValue()==null)
			return " - La date d'expiration de la carte doit etre fournie\n";
		else if(Date.valueOf(this.dateExpiration.getValue()).before(currentDate))
			return " - La date d'expiration de la carte doit etre valide";
		else
			return "";
	}

	public void initialize(URL location, ResourceBundle resources) {
		this.prix.setText(this.reservation.getPrix()+" "+DEVISE);
	}
	
}
