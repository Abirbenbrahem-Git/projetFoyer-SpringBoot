package tn.esprit.twin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.twin3.entity.Bloc;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

    //1er methode
    @Query(value = "SELECT * FROM Bloc WHERE nomBloc = nom", nativeQuery = true)
        Bloc ByNomBloc(String nom);

    //2eme methode//jpql
    @Query(value = "SELECT b FROM Bloc b WHERE b.nomBloc = :nom",nativeQuery = false)
    Bloc ByNom2 (@Param("nom") String nom);

    @Query("SELECT b FROM Bloc b JOIN b.foyer f WHERE f.nomFoyer = ?1")
    List<Bloc> blocByNomFoyer(String nom);


    //3eme methode

    List<Bloc> findBlocsByFoyerUniversiteNomUniversite(String nom);

    List<Bloc> findDistincBlocByNomBloc(String nom);

    Bloc findByNomBloc(String nomBloc);
    Bloc findByFoyerNomFoyer(String nomFoyer);
}
