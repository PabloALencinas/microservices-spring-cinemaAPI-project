package com.pabloagustin.movie;

import java.time.LocalTime;
import java.util.Set;

public class MovieResponse {

	private Integer movieId;
	private String name;
	private String description;
	private String showtimes;

	public MovieResponse(){}

	public MovieResponse(String name, String description, String showtimes) {
		this.name = name;
		this.description = description;
		this.showtimes = showtimes;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(String showtimes) {
		this.showtimes = showtimes;
	}
}
