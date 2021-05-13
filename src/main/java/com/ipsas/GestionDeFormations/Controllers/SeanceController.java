package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Seance;
import com.ipsas.GestionDeFormations.Services.SeanceService;
import com.ipsas.GestionDeFormations.Services.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
@Tag(name = "Seance Conroller", description = "Full CRUD for Seance Model")
public class SeanceController {

    private final SeanceService seanceService;


    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping
    public ResponseEntity<List<Seance>> index(){
        List<Seance> l = seanceService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seance> findById(@PathVariable("id") Long id){
        Seance e = seanceService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Seance> add(@RequestBody Seance seance){
        Seance e = seanceService.addSeance(seance);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Seance> update(@RequestBody Seance seance){
        Seance e = seanceService.updateSeance(seance);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        seanceService.deleteSeance(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
