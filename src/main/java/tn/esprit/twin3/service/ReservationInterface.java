package tn.esprit.twin3.service;

import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.entity.Reservation;

import java.util.List;

public interface ReservationInterface {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);

    public Reservation ajouterReservation (long idBloc, long cinEtudiant) ;
    public Reservation annulerReservation (long cinEtudiant) ;
}
