package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.dto.EtudiantDTO;
import tn.esprit.twin3.entity.Etudiant;
import tn.esprit.twin3.repository.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantService implements EtudiantInterface{

    EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.getReferenceById(idEtudiant);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    public EtudiantDTO convertTODTO(Etudiant etudiant) {
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        etudiantDTO.setName(etudiant.getNomE());
        etudiantDTO.setFamilyName(etudiant.getEcole());
        return etudiantDTO;
    }

    public EtudiantDTO getEtudiantByIdDTO(long idEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé avec ID : " + idEtudiant));

        return convertTODTO(etudiant);
    }


}
