package com.cinema.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cinema.dto.FilmDto;

public class FilmDAO extends CinemaDAO<FilmDto>{
public List<FilmDto> findAll() {
		
		//Création d'une liste de film vide
		List<FilmDto> films = new ArrayList<FilmDto>();
		try {
			//Requete vers la base de données pour récupérer la liste des films
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,titre,date_sortie,genre,url from film");
			
			//Exécution de la requête et récupération du résultats
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			while (result.next()) {
				int id = result.getInt(1);
				String titre = result.getString(2);
				String date_sortie = result.getString(3);
				String genre = result.getString(4);
				String url = result.getString(5);
				
				//Création d'un film
				FilmDto film = new FilmDto(id,titre,date_sortie,genre,url);
				
				//Ajout du film à la liste des films qui sera retrournée 
				films.add(film);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	public FilmDto findById(int id) {
		FilmDto film=new FilmDto();
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("Select id,titre,date_sortie,genre,url from film where id=?");
			st.setInt(1, id);
			ResultSet result = st.executeQuery();
			
			//Parcrous du résultat
			result.next();
			String titre = result.getString(2);
			String date_sortie = result.getString(3);
			String genre = result.getString(4);
			String url = result.getString(5);
				
			//Création d'un film
			film.setId(id);
			film.setTitre(titre);
			film.setDate_sortie(date_sortie);
			film.setGenre(genre);
			film.setUrl(url);
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return film;
	}

	public boolean save(FilmDto obj) {
		try {
			PreparedStatement st;
			if (obj.getId()==-1) {
				st =FilmDAO.cn.prepareStatement("insert into film (titre,date_sortie,genre,url) values (?,?,?)");
			}
			else {
				st =CinemaDAO.cn.prepareStatement("insert into film (titre,date_sortie,genre,url,id) values (?,?,?,?)");
				st.setInt(5, obj.getId());
			}
			st.setString(1, obj.getTitre());
			st.setString(2, obj.getDate_sortie());
			st.setString(3, obj.getGenre());
			st.setString(4, obj.getUrl());
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("delete from film where id=?");
			st.setInt(1, id);
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean update(int id,FilmDto obj) {
		try {
			PreparedStatement st =CinemaDAO.cn.prepareStatement("update film set id=?,titre=?,date_sortie=?,genre=?,url=? where id=?");
			FilmDto film= this.findById(id);
			
			if(obj.getId()==-1)
				st.setInt(1, film.getId());
			else
				st.setInt(1, obj.getId());
			
			
			if(obj.getTitre()==null)
				st.setString(2, film.getTitre());
			else 
				st.setString(2, obj.getTitre());
			
			
			if(obj.getDate_sortie()==null)
				st.setString(3, film.getDate_sortie());
			else 
				st.setString(3, obj.getDate_sortie());
			
			
			if(obj.getGenre()==null)
				st.setString(4, film.getGenre());
			else 
				st.setString(4, obj.getGenre());
			
			if(obj.getUrl()==null)
				st.setString(5, film.getUrl());
			else
				st.setString(5, obj.getUrl());
			
			st.setInt(6, id);
			
			
			if(st.executeUpdate()==1) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	

}
