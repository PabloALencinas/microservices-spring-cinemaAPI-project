package com.pabloagustin.reservation.payloads;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

public record ReservationRequest(
		Long userId,
		Long movieId,
		String reservationDateHour
) {
}
