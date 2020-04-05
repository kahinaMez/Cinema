package com.cinema.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.cinema.controllers.DetailsFilm;
import com.cinema.models.Projection;
import com.cinema.models.ProjectionDetail;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProjectionsController implements Initializable{
	
	@FXML private VBox container;
	@FXML private AnchorPane root;
	@FXML private HBox title;
	
	Projection model = new Projection();
	
	public void initialize(URL location, ResourceBundle resources) {
		initAutoResize();
		loadFilms();
	}
	
	private void loadFilms() {
		for (ProjectionDetail proj : model.getProjections()) {
			DetailsFilm detail = new DetailsFilm(proj);
			this.addProjection(detail);
		}
	}
	
	private void addProjection(DetailsFilm film) {
		HBox hbox=new HBox();
		hbox.getChildren().add(film);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setMaxWidth(DetailsFilm.getRootWidth());
		hbox.setMinHeight(DetailsFilm.getRootHeight());
		Insets inset = new Insets(0, 0, 10, 0);
		VBox.setMargin(hbox, inset);
		container.getChildren().add(hbox);
	}
	
	private void initAutoResize() {
		root.widthProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(newValue.doubleValue()>DetailsFilm.getRootWidth())
					container.setPrefWidth(newValue.doubleValue());
				else
					container.setPrefWidth(DetailsFilm.getRootWidth());
			}
		});
	}
	
}
