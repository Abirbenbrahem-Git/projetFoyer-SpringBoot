package tn.esprit.twin3.service;

import tn.esprit.twin3.entity.Universite;

import java.util.List;

public interface UniversiteInterface {

    public Universite affecterFoyerAUniversite (Long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite (Long idUniversite) ;

    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);

}
