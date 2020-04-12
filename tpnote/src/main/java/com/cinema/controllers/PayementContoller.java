package com.cinema.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.cinema.models.Payement;
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
	
	private Payement payement ;
	private Scenes sc;
	
	public PayementContoller() {
		this.payement = Payement.getInstance();
		this.sc = Scenes.getInstance();
	}
	
	@FXML
	public void annuler() {
		Scenes sc = Scenes.getInstance();
		sc.switchToProjectionsScene();
	}
	
	@FXML
	public void valider() {
		boolean confirm = payement.reserver();
		
		if(confirm) {
			sc.switchToProjectionsScene();
		}
		else {
			System.out.println("Erreur lors du paiement ");
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.prix.setText(this.payement.getPrix()+" "+DEVISE);
	}
	
}
