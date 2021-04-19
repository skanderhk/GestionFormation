package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Services.GroupeService;
import com.ipsas.GestionDeFormations.Services.MatiereService;
import com.ipsas.GestionDeFormations.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupe")
public class GroupeController {

    private final GroupeService groupeService;
    private final UserService userService;
    private final MatiereService matiereService;

    public GroupeController(GroupeService groupeService, UserService userService, MatiereService matiereService) {
        this.groupeService = groupeService;
        this.userService = userService;
        this.matiereService = matiereService;
    }

    @GetMapping("/all")
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

    @PostMapping ("{gid}/addstudent/{uid}")
    public ResponseEntity<Groupe> addUserToGroupe(@PathVariable("uid") Long uid,@PathVariable("gid") Long gid) {
        User u = userService.findOneById(uid);
        Groupe g = groupeService.findOneById(gid);
        Groupe e = groupeService.addStudent(u,g);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PostMapping ("{gid}/deletestudent/{uid}")
    public ResponseEntity<Groupe> deleteUserfromGroupe(@PathVariable("uid") Long uid,@PathVariable("gid") Long gid) {
        User u = userService.findOneById(uid);
        Groupe g = groupeService.findOneById(gid);
        Groupe e = groupeService.deleteStudent(u,g);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PostMapping ("{gid}/addmatiere/{mid}")
    public ResponseEntity<Groupe> addMatiereToGroupe(@PathVariable("mid") Long mid,@PathVariable("gid") Long gid){
        Matiere m = matiereService.findOneById(mid);
        Groupe g = groupeService.findOneById(gid);
        Groupe e = groupeService.addMatiere(m,g);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PostMapping ("{gid}/deletematiere/{mid}")
    public ResponseEntity<Groupe> deleteMatierefromGroupe(@PathVariable("mid") Long mid,@PathVariable("gid") Long gid){
        Matiere m = matiereService.findOneById(mid);
        Groupe g = groupeService.findOneById(gid);
        Groupe e = groupeService.deleteMatiere(m,g);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }


}
