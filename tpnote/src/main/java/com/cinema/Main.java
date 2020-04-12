package com.cinema;

import com.cinema.utils.Scenes;

import javafx.application.Application; 
import javafx.stage.Stage;

public class Main extends Application{


	@Override
    public void start(Stage stage) throws Exception {
	   Scenes sc = new Scenes(stage);
	   sc.switchToProjectionsScene();
    }

    public static void main(String[] args) {
    	//UserDAO dao=new UserDAO();
    	//UserDto user=new UserDto(1,"meziani","kahina","1993-07-06","36 avenue de brogny","kahina123","kahina.meziani@hotmail.com");
    	//UserDto user2=new UserDto(6,"aissaoui","walid","1993-07-06","36 avenue de brogny","kahina123","kahina.meziani@hotmail.com");
    	//UserDto user3=new UserDto(3,"benmaamar","yasmine","1993-07-06","36 avenue de brogny","kahina123","kahina.meziani@hotmail.com");
    	
    	//dao.save(user);
    	//dao.save(user2);
    	//dao.save(user3);
    	
    	//dao.delete(3);
    	//System.out.println(dao.findAll());
    	
    	//UserDto use=dao.findById(2);
    	//System.out.println(use);
    	
    	//dao.update(1, user2);
    	
    	//SalleDAO dao= new SalleDAO();
    	//SalleDto salle=new SalleDto(1,50);
    	//SalleDto salle1=new SalleDto(2,51);
    	//SalleDto salle2=new SalleDto(3,52);
    	//SalleDto salle3=new SalleDto(4,53);
    	//dao.save(salle);
    	//dao.save(salle1);
    	//dao.save(salle2);
    	//dao.save(salle3);
    	
    	//System.out.println(dao.delete(3));
    	
    	//SalleDto sal=dao.findById(1);
    	//System.out.println(sal);
    	
    	//System.out.println(dao.findAll());    	
    	
    	//dao.update(1, salle2);
    	
    	
    	
    	//ProjectionDAO dao=new ProjectionDAO();
    	//ProjectionDto projection=new ProjectionDto(3,"1996-06-06",35,8.5);
    	//ProjectionDto projection2=new ProjectionDto(6,"1997-08-06",36,8.5);
    	//dao.save(projection);
    	//dao.save(projection2);
    	
    	//ProjectionDto projection2=dao.findById(3);
    	//System.out.println(projection2);
    	
    	//System.out.println(dao.delete(3));
    	
    	//dao.update(6, projection); 
    	
    	//List<ProjectionDto> list=dao.findAll();
    	//for()
    	//System.out.println(list);
    	launch(args);
    

    }
}
