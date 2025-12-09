package tn.esprit.twin3.controller;


import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Universite;
import tn.esprit.twin3.service.UniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteRestController {

    UniversiteService universiteService;

    public UniversiteRestController(UniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    //http://localhost:8081/universite/foyer/1/Esprit
    @PutMapping("/foyer/{id-foyer}/{nom-universite}")
    public Universite affecterFoyerAUniversite(@PathVariable("id-foyer") Long idFoyer,@PathVariable("nom-universite") String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    //http://localhost:8081/universite/foyer/1
    @PutMapping("/foyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }

    @GetMapping
    public List<Universite> getAllUniversities() {
        return universiteService.retrieveAllUniversities();
    }

    @GetMapping("/{id}")
    public Universite getUniversite(@PathVariable long id) {
        return universiteService.retrieveUniversite(id);
    }

    @PostMapping
    public Universite createUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody Universite u) {
        return universiteService.updateUniversite(u);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable long id) {
        universiteService.removeUniversite(id);
    }
}
