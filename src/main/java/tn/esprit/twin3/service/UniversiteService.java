package tn.esprit.twin3.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.entity.Universite;
import tn.esprit.twin3.repository.FoyerRepository;
import tn.esprit.twin3.repository.UniversiteRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;


@Service
public class UniversiteService implements UniversiteInterface {

    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;

    public UniversiteService(FoyerRepository foyerRepository, UniversiteRepository universiteRepository) {
        this.foyerRepository = foyerRepository;
        this.universiteRepository = universiteRepository;
    }


    //@Scheduled(fixedRate=5000)
    //@Scheduled(cron="0 */30 8 * * *")//8:00:00 et8:30:00
    //List<Universite> testSheduled(){
      //  for(Universite u: universiteRepository.findAll()){
        //    System.out.println(u.toString());
        //    log.info("universite"+u.toString());
        //}
        //return universiteRepository.findAll();
    //}


    

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        //recherche et recuperation
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(null);
        Universite universite = universiteRepository.findUniversiteByNomUniversite(nomUniversite);

        //assignement parent to fils
        universite.setFoyer(foyer);

        //persistance
        return universiteRepository.save(universite);

    }

    @Override
    public Universite desaffecterFoyerAUniversite(Long idUniversite) {
        //recherche et recuperation
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(null);

        //parent.setFils(null)

        universite.setFoyer(null);

        //persistance
        return universiteRepository.save(universite);

    }

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        Optional<Universite> u = universiteRepository.findById(idUniversite);
        return u.orElse(null);
    }

    public void removeUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

}
