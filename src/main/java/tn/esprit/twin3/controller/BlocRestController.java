package tn.esprit.twin3.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.twin3.entity.Bloc;
import tn.esprit.twin3.entity.Chambre;
import tn.esprit.twin3.service.BlocInterface;

import java.util.List;
@RestController
public class BlocRestController {

    BlocInterface blocInterface;

    public BlocRestController(BlocInterface blocInterface) {
        this.blocInterface = blocInterface;
    }

    @PostMapping("/bloc")
    Bloc addBloc(@RequestBody Bloc bloc){
        return blocInterface.addBloc(bloc);
    }

    @PutMapping
    public Bloc updateBloc(@RequestBody Bloc bloc){
        return blocInterface.updateBloc(bloc);
    }


    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id){
        blocInterface.deleteBloc(id);
    }

    @GetMapping("/{id}")
    public Bloc viewBloc(@PathVariable Long id){
        return blocInterface.viewBloc(id);
    }

    @GetMapping("/")
    public List<Bloc> viewAllBloc(){
        return blocInterface.viewAllBloc();
    }

    //http://localhost:8081/nom/bloca
    @GetMapping("/nom/{nomBloc}")
    public Bloc viewBlocByNom(@PathVariable("nomBloc") String nomBloc) {
        return blocInterface.viewBlocByNom(nomBloc);
    }
    //http://localhost:8081/foyer/foyera
    @GetMapping("/foyer/{nomFoyer}")
    public Bloc viewBlocByFoyer(@PathVariable("nomFoyer") String nomFoyer) {
        return blocInterface.viewBlocByFoyer(nomFoyer);
    }

    @PostMapping("/{idBloc}/chambres")
    public Bloc affecterChambres(@PathVariable long idBloc, @RequestBody List<Long> numChambre) {
        return blocInterface.affecterChambresABloc(numChambre, idBloc);
    }


}
