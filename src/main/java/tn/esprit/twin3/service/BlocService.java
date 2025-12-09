package tn.esprit.twin3.service;

import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.repository.BlocRepository;
import tn.esprit.twin3.repository.ChambreRepository;

import java.util.*;

@Service
public class BlocService implements BlocInterface {

    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    public BlocService(BlocRepository blocRepository, ChambreRepository chambreRepository) {
        this.blocRepository = blocRepository;
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc viewBloc(Long idBloc) {
        return blocRepository.getReferenceById(idBloc);
    }

    @Override
    public List<Bloc> viewAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc viewBlocByNom(String nomBloc) {
        return blocRepository.findByNomBloc(nomBloc);
    }

    @Override
    public Bloc viewBlocByFoyer(String nomFoyer) {
        return blocRepository.findByFoyerNomFoyer(nomFoyer);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow();
        List<Chambre> chambres = chambreRepository.findAllById(numChambre);
        bloc.setChambres(new HashSet<>(chambres));
        return blocRepository.save(bloc);
    }


}
