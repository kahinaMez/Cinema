package com.cinema.utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Scenes {
	
	private Stage stage ;
	private static Scenes scenes =null;
	
	public Scenes(Stage stage) {
		this.stage=stage;
		this.stage.setTitle("Cinema cosmos");
		this.stage.setMaximized(true);
		this.miximiser();
		scenes = this;
	}
	
	public static Scenes getInstance() {
		return scenes;
	}
	
	public void switchToProjectionsScene() {
		switchToScene("views/Projections.fxml");
	}
	
	public void switchToLoginScene() {
		switchToScene("views/Login.fxml");
	}
	
	public void switchToSiginScene() {
		switchToScene("views/Inscription.fxml");
	}
	
	public void switchToPayment() {
		switchToScene("views/Payement.fxml");
	}
	
	private void switchToScene(String view) {
		try {
			Parent login = FXMLLoader.load(getClass().getClassLoader().getResource(view));
			Scene scene = new Scene(login);
			
	        stage.setScene(scene);
	        stage.setResizable(true);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void miximiser() {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
	}
}
