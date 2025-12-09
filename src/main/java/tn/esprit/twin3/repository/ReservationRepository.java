package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin3.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}