package com.pabloagustin.reservation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reservations")
public class Reservation {

	@Id
	@SequenceGenerator(
			name = "reservation_id_sequence",
			sequenceName = "reservation_id_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "reservation_id_sequence"
	)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "movie_id")
	private Long movieId;

	private String reservationDateHour;
}
