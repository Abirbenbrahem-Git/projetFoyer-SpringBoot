package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin3.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByCin(long cinEtudiant);
}
