package com.cinema.models;

import com.cinema.dto.FilmDto;
import com.cinema.dto.ProjectionDto;
import com.cinema.dto.SalleDto;

public class ProjectionDetail {
	
	private ProjectionDto projection;
	private FilmDto film;
	private SalleDto salle;
	
	public ProjectionDetail(ProjectionDto projection, FilmDto film, SalleDto salle) {
		super();
		this.projection = projection;
		this.film = film;
		this.salle = salle;
	}

	public ProjectionDto getProjection() {
		return projection;
	}
	public void setProjection(ProjectionDto projection) {
		this.projection = projection;
	}
	public FilmDto getFilm() {
		return film;
	}
	public void setFilm(FilmDto film) {
		this.film = film;
	}
	public SalleDto getSalle() {
		return salle;
	}
	public void setSalle(SalleDto salle) {
		this.salle = salle;
	}
	
}
