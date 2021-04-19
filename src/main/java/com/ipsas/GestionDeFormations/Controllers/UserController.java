package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Note;
import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Services.NoteService;
import com.ipsas.GestionDeFormations.Services.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final NoteService noteService;

    public UserController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> index(){
        List<User> l = userService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        User e = userService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<User> add(@RequestBody User employee){
        User e = userService.addUser(employee);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<User> update(@RequestBody User employee){
        User e = userService.updateUser(employee);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping ("{id}/addnote/{nid}")
    public ResponseEntity<User> addNote(@PathVariable("id") Long id,@PathVariable("nid") Long nid){
        Note note = noteService.findOneById(nid);
        User user = userService.findOneById(id);
        User e = userService.addStudentNote(user,note);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }


}
