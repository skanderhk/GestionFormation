package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Student;
import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Services.GroupeService;
import com.ipsas.GestionDeFormations.Services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")
@Tag(name = "Group Conroller", description = "Full CRUD for Group Model")
@SecurityRequirement(name = "JwtAuthentication")
public class GroupeController {

    private final GroupeService groupeService;
    private final StudentService studentService;



    public GroupeController(GroupeService groupeService, StudentService studentService) {
        this.groupeService = groupeService;
        this.studentService = studentService;
    }

    @Operation(summary = "Get List of all Groups")
    @GetMapping("/")
    public ResponseEntity<List<Groupe>> index(){
        List<Groupe> l = groupeService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groupe> findById(@PathVariable("id") Long id){
        Groupe e = groupeService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Groupe> add(@RequestBody Groupe groupe){
        Groupe e = groupeService.addGroupe(groupe);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Groupe> update(@RequestBody Groupe groupe){
        Groupe e = groupeService.updateGroupe(groupe);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        groupeService.deleteGroupe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
