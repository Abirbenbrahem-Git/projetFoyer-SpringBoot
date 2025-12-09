package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.entity.TypeChambre;
import tn.esprit.twin3.service.ChambreInterface;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreRestController {

    ChambreInterface chambreInterface;

    public ChambreRestController(ChambreInterface chambreInterface) {
        this.chambreInterface = chambreInterface;
    }

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreInterface.retrieveAllChambres();
    }

    @GetMapping("/{id}")
    public Chambre getChambre(@PathVariable long id) {
        return chambreInterface.retrieveChambre(id);
    }

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre c) {
        return chambreInterface.addChambre(c);
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre c) {
        return chambreInterface.updateChambre(c);
    }

    @GetMapping("/par-universite/{nom}")
    public List<Chambre> getChambres(@PathVariable("nom") String nomUniversite) {
        return chambreInterface.getChambresParNomUniversite(nomUniversite);
    }



}
