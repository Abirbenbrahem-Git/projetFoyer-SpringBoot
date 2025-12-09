package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.entity.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    Universite findUniversiteByNomUniversite(String nomUniversite);

    //JPQL: Java Persistance Query Language
    //service pour recuperer l'universite qui possede la chambre donnée par son numeroChambre
    @Query("select universite from Universite universite join universite.foyer foyer join foyer.blocs bloc join bloc.chambres chambre where chambre.numChambre=:numero")
    Universite universiteByNumeroChambre(@Param("numero") long numeroChambre);

    //Methode JPA ou bien keywords

    Universite findUniversiteByFoyerBlocsChambresNumChambre(long numero);

    Universite findByNomUniversite(String nomUniversite);
}
