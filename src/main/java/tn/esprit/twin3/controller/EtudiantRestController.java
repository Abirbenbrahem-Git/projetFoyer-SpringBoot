package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Etudiant;
import tn.esprit.twin3.service.EtudiantInterface;

import java.util.List;

@RestController
@RequestMapping("/etudiants")

public class EtudiantRestController {

    EtudiantInterface etudiantInterface;

    public EtudiantRestController(EtudiantInterface etudiantInterface) {
        this.etudiantInterface = etudiantInterface;
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantInterface.retrieveAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiant(@PathVariable long id) {
        return etudiantInterface.retrieveEtudiant(id);
    }

    @PostMapping
    public List<Etudiant> createEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantInterface.addEtudiants(etudiants);
    }

    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantInterface.updateEtudiant(e);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable long id) {
        etudiantInterface.removeEtudiant(id);
    }

}
