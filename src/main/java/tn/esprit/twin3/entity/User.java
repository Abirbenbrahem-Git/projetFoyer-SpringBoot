package tn.esprit.twin3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;
    String nom;
    String prenom;
    @Column(length=8)
    long cin;
    @Column(length=8)
    @Enumerated(EnumType.STRING)
    TypeUser typeUser;

}
