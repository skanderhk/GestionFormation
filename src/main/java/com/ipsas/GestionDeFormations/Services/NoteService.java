package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Exceptions.NoteNotFoundException;
import com.ipsas.GestionDeFormations.Models.Note;
import com.ipsas.GestionDeFormations.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepo;

    @Autowired
    public NoteService(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    public Note addNote(Note E){
        return noteRepo.save(E);
    }

    public List<Note> findAll(){
        return noteRepo.findAll();
    }

    public Note findOneById(Long id){
        return noteRepo.findById(id).orElseThrow(()-> new NoteNotFoundException("Note by id : "+id+" is not found !" ));
    }

    public Note updateNote(Note E){
        return noteRepo.save(E);
    }

    public void deleteNote(Long id){
        noteRepo.deleteById(id);
    }

}
