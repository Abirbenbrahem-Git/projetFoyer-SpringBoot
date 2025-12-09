package tn.esprit.twin3.service;

import tn.esprit.twin3.dto.EtudiantDTO;
import tn.esprit.twin3.entity.Etudiant;

import java.util.List;

public interface EtudiantInterface {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
    public EtudiantDTO getEtudiantByIdDTO(long idEtudiant);
}
