package com.cinema.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class DetailsFilm extends Pane{
	
	private static final String DEVISE = "Euro";
	
	@FXML private ImageView poster;
	@FXML private Label title;
	@FXML private Label genre;
	@FXML private Label dateSortie;
	@FXML private Hyperlink acteurs;
	@FXML private Button reserver;
	@FXML private Label dateProjection;
	@FXML private Label nbPlaces;
	@FXML private Label tarif;
	
	
	public DetailsFilm () {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/DetailsFilm.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	public void setPoster(String link) {
		Image image = new Image(link);
		poster.setImage(image);
	}
	
	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	public void setGenre(String genre) {
		this.genre.setText(genre);
	}
	
	public void setDateSortie(String dataSortie) {
		this.dateSortie.setText(dataSortie);
	}
	
	public void setDateProjection(String dataProjection) {
		this.dateProjection.setText(dataProjection);
	}
	
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces.setText(""+nbPlaces);
	}
	
	public void setTarif(int tarif) {
		this.tarif.setText(tarif+" "+DEVISE);
	}
	
	public void reserver() {
		
	}
}
