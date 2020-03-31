package com.cinema.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.cinema.models.Home;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class HomeController implements Initializable{
	
	private final static int minWidth=1200;
	private final static double rapport = 0.52;
	
	@FXML
	private Label title;
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private ScrollPane scrollPane;
	
	@FXML
	private ImageView affiche;
	
	private Home home;
	
	public HomeController() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("img/Badboysforlife_official_Blackwomenmag.png");
		list.add("img/sonic.jpg");
		
		home = new Home(list);
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		root.heightProperty().addListener(new ChangeListener<Number>() {

			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				
			}
		});
		
		root.widthProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				resizeImage();
				repositioneLabel();
			}
		});
		
		Timeline t= new Timeline(new KeyFrame(Duration.seconds(1.5), new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				Image image = new Image(home.getNextUrl());
				affiche.setImage(image);
			}
		}));
		
		
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
	}
	
	private void resizeImage() {
		affiche.setFitHeight(root.getWidth()*rapport);
		affiche.setFitWidth(root.getWidth());
	}
	
	private void repositioneLabel() {
		double reste = root.getWidth()-title.getPrefWidth()-10;
		System.out.println(root.getWidth());
		System.out.println(title.getPrefWidth());
		System.out.println(reste);
		AnchorPane.setLeftAnchor(title, reste/2);
		AnchorPane.setRightAnchor(title, reste/2);
	}
}
