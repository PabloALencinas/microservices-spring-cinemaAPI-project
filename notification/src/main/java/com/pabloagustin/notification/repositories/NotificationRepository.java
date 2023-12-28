package com.pabloagustin.notification.repositories;

import com.pabloagustin.notification.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
