package com.cinema.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.cinema.models.User;
import com.cinema.utils.FxDialogs;
import com.cinema.utils.Scenes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class LoginController implements Initializable{
		
	@FXML private TextField email;
	@FXML private PasswordField mdp;
	@FXML private AnchorPane root;
	@FXML private ImageView background;
		
	private User model = User.getInstance();
	
	@FXML
	public void seConnecter(ActionEvent event) {
		boolean success = model.connexion(email.getText(), mdp.getText());
		
		if(success) {
			Scenes sc = Scenes.getInstance();
			sc.switchToProjectionsScene();
		}
		else
			FxDialogs.showError("Erreur", "Votre login et(ou) votre mot de passe sont incorrectes");
	}
	
	@FXML
	public void signin(ActionEvent event) {
		Scenes sc = Scenes.getInstance();
		sc.switchToSiginScene();
	}

	public void initialize(URL location, ResourceBundle resources) {

		root.widthProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				background.setFitWidth(newValue.doubleValue());
			}
		});
		
		root.heightProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				background.setFitHeight(newValue.doubleValue());
			}
		});
	}
	
	

}
