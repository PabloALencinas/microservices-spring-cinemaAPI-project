package com.pabloagustin.reservation.controllers;

import com.pabloagustin.reservation.payloads.ReservationRequest;
import com.pabloagustin.reservation.services.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
@Slf4j
public class ReservationController {

	private final ReservationService reservationService;

	@PostMapping("/create-reservation/{userId}")
	public void registerReservation(@PathVariable Long userId, @RequestBody ReservationRequest reservationRequest){
		log.info("Reservation {} registered.", reservationRequest);
		reservationService.processReservation(userId, reservationRequest);
	}

}
