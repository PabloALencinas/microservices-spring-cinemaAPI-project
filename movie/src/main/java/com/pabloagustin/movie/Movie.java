package com.pabloagustin.movie;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@SequenceGenerator(
			name = "notification_id_sequence",
			sequenceName = "notification_id_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "notification_id_sequence"
	)
	private Integer id;
	private String name;
	private String description;
	private String showtimes;

	public Movie(){}

	public Movie(String name, String description, String showtimes) {
		this.name = name;
		this.description = description;
		this.showtimes = showtimes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
