package com.pabloagustin.reservation.services;

import com.pabloagustin.amqp.RabbitMQMessageProducer;
import com.pabloagustin.clients.notification.NotificationRequest;
import com.pabloagustin.reservation.clients.MovieFeignClient;
import com.pabloagustin.reservation.clients.UserFeignClient;
import com.pabloagustin.reservation.models.Reservation;
import com.pabloagustin.reservation.payloads.Movie;
import com.pabloagustin.reservation.payloads.ReservationRequest;
import com.pabloagustin.reservation.payloads.User;
import com.pabloagustin.reservation.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

	private final UserFeignClient userClient;
	private final MovieFeignClient movieClient;
	private final ReservationRepository reservationRepository;
	private final RabbitMQMessageProducer rabbitMQMessageProducer;

	public void processReservation(Long userId, ReservationRequest reservationRequest){

		Optional<User> currentUser = Optional.ofNullable(userClient.getUserById(userId));

		if(currentUser.isPresent()){

			// Fetch movie details using OpenFeign client
			Movie movie = movieClient.getMovieById(reservationRequest.movieId());

			if (movie.getShowtimes().equals(reservationRequest.reservationDateHour())){
				Reservation reservation = Reservation.builder()
						.userId(reservationRequest.userId())
						.movieId(reservationRequest.movieId())
						.reservationDateHour(reservationRequest.reservationDateHour())
						.build();

				reservationRepository.save(reservation);

				NotificationRequest notificationRequest = new NotificationRequest(
						Math.toIntExact(reservation.getId()),
						Math.toIntExact(reservation.getUserId()),
						String.format("Success")
				);

				rabbitMQMessageProducer.publish(
						notificationRequest,
						"internal.exchange",
						"internal.notification.routing-key"
				);

			} else {
				throw new RuntimeException("There is not available showtime");
			}

		} else {
			throw new RuntimeException("User does not exist");
		}
	}
}
