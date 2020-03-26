package com.cinema;

import java.util.List;

import com.cinema.dao.ActeurDAO;
import com.cinema.dto.ActeurDto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/Home.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	/*ActeurDAO dao = new ActeurDAO();
    	List<ActeurDto> acteurs=dao.findAll();
    	
    	for(ActeurDto acteur : acteurs) {
    		System.out.println(acteur);
    	}*/
    	
        launch(args);
    }

}
