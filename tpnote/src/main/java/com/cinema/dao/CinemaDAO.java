package com.cinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class CinemaDAO<T> {
	
	/* Connexion à la base de données */
	private static final int port = 3306;
	private static final String bdd = "cinema";
	private static final String host = "localhost";
	
	private static final String url = "jdbc:mysql://"+host+":"+port+"/"+bdd+"?serverTimezone=UTC";
	private static final String utilisateur = "root";
	private static final String motDePasse = "";
	
	protected static Connection cn =null;
	
	static {
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		    cn = DriverManager.getConnection( url, utilisateur, motDePasse );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
			e.printStackTrace();
		}
		catch ( SQLException e ) {
		    /* Gérer les éventuelles erreurs ici */
			e.printStackTrace();
		} 
		
	}
	
	abstract public List<T> findAll();
	abstract public T findById(int id);
	abstract public boolean save(T obj);
	abstract public boolean delete(int id);
	abstract public boolean update(T obj);

}
