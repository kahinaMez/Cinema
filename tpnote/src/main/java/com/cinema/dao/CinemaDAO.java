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
	
	private static final String url = "jdbc:mysql://"+host+":"+port+"/"+bdd;
	private static final String utilisateur = "root";
	private static final String motDePasse = "";
	
	protected static Connection cn =null;
	
	static {
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		try {
		    cn = DriverManager.getConnection( url, utilisateur, motDePasse );

		    /* Ici, nous placerons nos requêtes vers la BDD */
		    /* ... */

		} catch ( SQLException e ) {
		    /* Gérer les éventuelles erreurs ici */
		} finally {
		    if ( cn != null )
		        try {
		            /* Fermeture de la connexion */
		            cn.close();
		        } catch ( SQLException ignore ) {
		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		        }
		}
	}
	
	
	abstract public List<T> findAll();
	abstract public T findById(int id);
	abstract public boolean save(T obj);
	abstract public boolean delete(int id);
	abstract public boolean update(T obj);

}
