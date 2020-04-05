package com.cinema.models;

import java.util.ArrayList;
import java.util.List;

import com.cinema.dao.FilmDAO;
import com.cinema.dao.ProjectionDAO;
import com.cinema.dao.SalleDAO;
import com.cinema.dto.FilmDto;
import com.cinema.dto.ProjectionDto;
import com.cinema.dto.SalleDto;

public class Projection {
	private ProjectionDAO projectionDao = new ProjectionDAO();
	private FilmDAO filmDao = new FilmDAO();
	private SalleDAO salleDao = new SalleDAO();
	
	private ArrayList<ProjectionDetail> projections = new ArrayList<ProjectionDetail>();
	
	public Projection() {
		List<ProjectionDto> projections = projectionDao.findAll();
		
		for(ProjectionDto projection : projections) {
			FilmDto film = filmDao.findById(projection.getId_film());
			SalleDto salle = salleDao.findById(projection.getId_salle());
			
			ProjectionDetail p = new ProjectionDetail(projection,film,salle);
			this.projections.add(p);
		}
	}
	
	public ArrayList<ProjectionDetail> getProjections(){
		return this.projections;
	}
	

}
