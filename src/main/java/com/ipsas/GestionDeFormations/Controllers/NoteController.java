package com.ipsas.GestionDeFormations.Controllers;

import com.ipsas.GestionDeFormations.Models.Note;
import com.ipsas.GestionDeFormations.Services.NoteService;
import com.ipsas.GestionDeFormations.Services.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@Tag(name = "Note Conroller", description = "Full CRUD for Note Model")
public class NoteController {

    private final NoteService noteService;



    public NoteController(NoteService noteService, StudentService studentService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> index(){
        List<Note> l = noteService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") Long id){
        Note e = noteService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Note> add(@RequestBody Note groupe){
        Note e = noteService.addNote(groupe);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Note> update(@RequestBody Note groupe){
        Note e = noteService.updateNote(groupe);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
