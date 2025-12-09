package tn.esprit.twin3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    String idReservation;
    LocalDate anneeUniversitaire;
    Boolean estValide;

    @ManyToOne
    Chambre chambre;

    @ManyToMany(mappedBy = "reservations")
    Set<Etudiant> etudiants;
}
