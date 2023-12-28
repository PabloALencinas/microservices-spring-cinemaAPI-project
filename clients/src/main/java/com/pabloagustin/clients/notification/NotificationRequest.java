package com.pabloagustin.clients.notification;

public record NotificationRequest(
		Integer toReservationId,
		Integer toUserId,
		String message
) {
}
