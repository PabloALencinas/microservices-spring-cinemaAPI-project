package com.pabloagustin.reservation.repositories;

import com.pabloagustin.reservation.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
