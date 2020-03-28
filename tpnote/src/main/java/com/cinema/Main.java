package com.cinema;

import java.util.List;

import com.cinema.dao.ActeurDAO;
import com.cinema.dao.FilmDAO;
import com.cinema.dto.ActeurDto;
import com.cinema.dto.FilmDto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
    public void start(Stage stage) throws Exception {
       /*Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/Home.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
    	FilmDAO dao=new FilmDAO();
    	FilmDto film=new FilmDto(3,"speederman","2013-05-06","fantastique");
    	//FilmDto film2=new FilmDto(2,"game of thrones","2015-06-06","fantastique");
    	
    	//dao.save(film2);
    	//dao.save(film);
    	
    	dao.update(2,film);
    	
    	//List<FilmDto> films=dao.findAll();
    	
    	
    	
    	//for(FilmDto film : films) 
    		System.out.println(film);
    	//dao.delete(3);
    	
    	/*ActeurDAO dao=new ActeurDAO();
    //	dao.delete(4);
    	ActeurDto acteur=new ActeurDto(45,"meziani","kahina","1993-07-06");
    	dao.save(acteur);
    	acteur=dao.findById(45);
    	System.out.println(acteur);
    	
    	
    	
    	
    	/* ActeurDto acteur=new ActeurDto(1,"meziani","kahina","1993-07-06");
    	
    	boolean res=dao.save(acteur);
    	if(res)
    		System.out.println("Opération réussie");
    	else 
    		System.out.println("Echec de l'operation");
    	
    	System.out.println("Runnig application ...");*/
    	
        launch(args);
    

    }
}
