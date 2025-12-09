package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.entity.Foyer;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {

}
