package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.entity.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

}
