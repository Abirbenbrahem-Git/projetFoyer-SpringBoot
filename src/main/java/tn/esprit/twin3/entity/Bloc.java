package tn.esprit.twin3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBlog;
    String nomBloc;
    long capaciteBloc;

    @ManyToOne
    Foyer foyer;

    @OneToMany
    Set<Chambre> chambres;
}
