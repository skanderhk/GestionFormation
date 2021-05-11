package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Services.MatiereService;
import com.ipsas.GestionDeFormations.Services.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matieres")
@Tag(name = "Matiere Conroller", description = "Full CRUD for Matiere Model")
public class MatiereController {

    private final MatiereService matiereService;
    private final StudentService studentService;



    public MatiereController(MatiereService matiereService, StudentService studentService) {
        this.matiereService = matiereService;
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Matiere>> index(){
        List<Matiere> l = matiereService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> findById(@PathVariable("id") Long id){
        Matiere e = matiereService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Matiere> add(@RequestBody Matiere groupe){
        Matiere e = matiereService.addMatiere(groupe);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Matiere> update(@RequestBody Matiere groupe){
        Matiere e = matiereService.updateMatiere(groupe);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        matiereService.deleteMatiere(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
