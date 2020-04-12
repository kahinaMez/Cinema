package com.cinema.controllers;

import java.io.IOException;

import com.cinema.models.ProjectionDetail;
import com.cinema.models.Reservation;
import com.cinema.models.User;
import com.cinema.utils.Scenes;

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
	private static final double WIDTH = 713;
	private static final double HEIGHT = 362;
	
	private ProjectionDetail projection;
	
	@FXML private ImageView poster;
	@FXML private Label title;
	@FXML private Label genre;
	@FXML private Label dateSortie;
	@FXML private Hyperlink acteurs;
	@FXML private Button reserver;
	@FXML private Label dateProjection;
	@FXML private Label nbPlaces;
	@FXML private Label tarif;
	
	
	public DetailsFilm (ProjectionDetail projection) {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/DetailsFilm.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
		this.projection = projection;
		setComponenets();
	}
	
	private void setComponenets() {
		this.setPoster(this.projection.getFilm().getUrl());
		this.setTitle(this.projection.getFilm().getTitre());
		this.setGenre(this.projection.getFilm().getGenre());
		this.setDateSortie(this.projection.getFilm().getDate_sortie());
		this.setDateProjection(this.projection.getProjection().getDate());
		this.setNbPlaces(this.projection.getProjection().getNb_place_libre());
		this.setTarif(this.projection.getProjection().getTarif());
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
	
	public void setTarif(double tarif) {
		this.tarif.setText(tarif+" "+DEVISE);
	}
	
	public static double getRootWidth() {
		return DetailsFilm.WIDTH;
	}
	
	public static double getRootHeight() {
		return DetailsFilm.HEIGHT;
	}
	
	@FXML
	public void reserver() {
		User user = User.getInstance();
		Scenes sc = Scenes.getInstance();
		if(user.isConnected()) {
			Reservation reservation = Reservation.getInstance();
			reservation.setProjection(this.projection.getProjection().getId());
			reservation.setPrix(this.projection.getProjection().getTarif());
			sc.switchToPayment();
		}
		else
			sc.switchToLoginScene();
	}
}
