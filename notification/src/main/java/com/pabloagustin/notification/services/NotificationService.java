package com.pabloagustin.notification.services;


import com.pabloagustin.clients.notification.NotificationRequest;
import com.pabloagustin.notification.models.Notification;
import com.pabloagustin.notification.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public void send(NotificationRequest notificationRequest){
		notificationRepository.save(
				Notification.builder()
						.toUserId(notificationRequest.toUserId())
						.toReservationId(notificationRequest.toReservationId())
						.sender("PabloAgustin")
						.message(notificationRequest.message())
						.sentAt(LocalDateTime.now())
						.build()
		);
	}

}