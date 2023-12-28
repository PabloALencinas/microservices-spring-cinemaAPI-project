package com.pabloagustin.movie;

import java.time.LocalTime;
import java.util.Set;


public class MovieRegistrationRequest{

	private String name;
	private String description;
	private String showtimes;

	public MovieRegistrationRequest(){}

	public MovieRegistrationRequest(String name, String description, String showtimes) {
		this.name = name;
		this.description = description;
		this.showtimes = showtimes;
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
