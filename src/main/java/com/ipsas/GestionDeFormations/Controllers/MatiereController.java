package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Services.MatiereService;
import com.ipsas.GestionDeFormations.Services.MatiereService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matiere")
public class MatiereController {

    private final MatiereService groupeService;
    private final MatiereService matierService;

    public MatiereController(MatiereService groupeService, MatiereService matierService) {
        this.groupeService = groupeService;
        this.matierService = MatiereController.this.matierService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Matiere>> index(){
        List<Matiere> l = groupeService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> findById(@PathVariable("id") Long id){
        Matiere e = groupeService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Matiere> add(@RequestBody Matiere groupe){
        Matiere e = groupeService.addMatiere(groupe);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Matiere> update(@RequestBody Matiere groupe){
        Matiere e = groupeService.updateMatiere(groupe);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        groupeService.deleteMatiere(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
