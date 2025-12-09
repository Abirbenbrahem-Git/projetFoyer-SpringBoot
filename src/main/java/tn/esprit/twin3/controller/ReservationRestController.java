package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Reservation;
import tn.esprit.twin3.service.ReservationInterface;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {
    ReservationInterface reservationInterface;

    public ReservationRestController(ReservationInterface reservationInterface) {
        this.reservationInterface = reservationInterface;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationInterface.retrieveAllReservation();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable String id) {
        return reservationInterface.retrieveReservation(id);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation res) {
        return reservationInterface.updateReservation(res);
    }

    @PostMapping("/ajouter")
    public Reservation ajouterReservation(
            @RequestParam long idBloc,
            @RequestParam long cinEtudiant) {
        return reservationInterface.ajouterReservation(idBloc, cinEtudiant);
    }

    @PutMapping("/annuler/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable long cinEtudiant) {
        return reservationInterface.annulerReservation(cinEtudiant);
    }
}
