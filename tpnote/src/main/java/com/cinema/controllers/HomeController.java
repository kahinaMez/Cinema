package com.cinema.controllers;

import java.io.Serializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FXML
	Button btn1;
	
	public void sayHello() {
		System.out.println("Hello world");
	}
}
