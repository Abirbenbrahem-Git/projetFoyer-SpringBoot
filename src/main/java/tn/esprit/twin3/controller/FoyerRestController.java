package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Foyer;
import tn.esprit.twin3.service.FoyerInterface;

import java.util.List;

@RestController
@RequestMapping("/foyers")

public class FoyerRestController {
    FoyerInterface foyerinterface;

    public FoyerRestController(FoyerInterface foyerinterface) {
        this.foyerinterface = foyerinterface;
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerinterface.retrieveAllFoyers();
    }

    @GetMapping("/{id}")
    public Foyer getFoyer(@PathVariable long id) {
        return foyerinterface.retrieveFoyer(id);
    }

    @PostMapping
    public Foyer createFoyer(@RequestBody Foyer f) {
        return foyerinterface.addFoyer(f);
    }

    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return foyerinterface.updateFoyer(f);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable long id) {
        foyerinterface.removeFoyer(id);
    }

    @PostMapping("/universite/{idUniversite}/foyer")
    public Foyer ajouterFoyerEtAffecter(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return foyerinterface.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }

}
