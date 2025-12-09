package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.entity.Universite;
import tn.esprit.twin3.repository.FoyerRepository;
import tn.esprit.twin3.repository.UniversiteRepository;

import java.util.List;

@Service
public class FoyerService implements FoyerInterface{

    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;

    public FoyerService(FoyerRepository foyerRepository, UniversiteRepository universiteRepository) {
        this.foyerRepository = foyerRepository;
        this.universiteRepository = universiteRepository;
    }

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.getReferenceById(idFoyer);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université introuvable"));

        foyer.setUniversite(universite);

        foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));

        return foyerRepository.save(foyer);
    }
}
