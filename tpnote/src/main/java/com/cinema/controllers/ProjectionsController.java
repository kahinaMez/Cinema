package com.cinema.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProjectionsController implements Initializable{
	
	@FXML
	VBox container;
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		DetailsFilm film = factory("Title", "Action", "21/15/1993", "30/308/515", 115, 54,"https://images-na.ssl-images-amazon.com/images/I/71rNJQ2g-EL._AC_SL1178_.jpg");

	}
	
	private void loadFilms() {
		//TODO load data from dao
	}
	
	private void addFilm(DetailsFilm film) {
		HBox hbox=new HBox();
		hbox.getChildren().add(film);
		hbox.setAlignment(Pos.TOP_CENTER);
		container.getChildren().add(hbox);
	}
	
	private DetailsFilm factory(String title,String genre,String dateSortie,String dataProjection,
			int nbPlaces, int tarif, String poster) {
		
		DetailsFilm film= new DetailsFilm();
		film.setTitle(title);
		film.setGenre(genre);
		film.setDateSortie(dateSortie);
		film.setDateProjection(dataProjection);
		film.setNbPlaces(nbPlaces);
		film.setTarif(tarif);
		film.setPoster(poster);
		
		return film;
	}
	
}
