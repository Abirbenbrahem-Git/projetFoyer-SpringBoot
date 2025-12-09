package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.*;
import tn.esprit.twin3.repository.ChambreRepository;
import tn.esprit.twin3.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChambreService implements ChambreInterface{

    ChambreRepository chambreRepository;
    UniversiteRepository universiteRepository;

    public ChambreService(ChambreRepository chambreRepository, UniversiteRepository universiteRepository) {
        this.chambreRepository = chambreRepository;
        this.universiteRepository = universiteRepository;
    }

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.getReferenceById(idChambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite uni = universiteRepository.findByNomUniversite(nomUniversite);
        if (uni == null) {
            return new ArrayList<>();
        }


        Foyer foyer = uni.getFoyer();
        if (foyer == null) {
            return new ArrayList<>();
        }

        List<Chambre> result = new ArrayList<>();

        for (Bloc b : foyer.getBlocs()) {
            for (Chambre c : b.getChambres()) {
                result.add(c);
            }
        }

        return result;

    }


}
