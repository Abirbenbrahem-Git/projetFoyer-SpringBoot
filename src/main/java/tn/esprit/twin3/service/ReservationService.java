package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.entity.Etudiant;
import tn.esprit.twin3.entity.Reservation;
import tn.esprit.twin3.repository.BlocRepository;
import tn.esprit.twin3.repository.ChambreRepository;
import tn.esprit.twin3.repository.EtudiantRepository;
import tn.esprit.twin3.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReservationService implements ReservationInterface{
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;
    BlocRepository blocRepository;


    public ReservationService(ReservationRepository reservationRepository, ChambreRepository chambreRepository, EtudiantRepository etudiantRepository, BlocRepository blocRepository) {
        this.reservationRepository = reservationRepository;
        this.chambreRepository = chambreRepository;
        this.etudiantRepository = etudiantRepository;
        this.blocRepository = blocRepository;
    }

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.getReferenceById(idReservation);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow();
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant).orElseThrow();

        Reservation reservation = new Reservation();
        reservation.setEstValide(true);


        HashSet<Etudiant> etudiants = new HashSet<>();
        etudiants.add(etudiant);
        reservation.setEtudiants(etudiants);

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            return null;
        }

        Reservation reservation = null;

        for (Reservation r : etudiant.getReservations()) {
            reservation = r;
            break;
        }

        if (reservation == null) {
            return null;
        }

        reservation.setEstValide(false);

        reservation.getEtudiants().remove(etudiant);

        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
            reservation.setChambre(null);
        }

        return reservationRepository.save(reservation);
    }


}
