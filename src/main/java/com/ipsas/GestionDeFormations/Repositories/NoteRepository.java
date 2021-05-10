package com.ipsas.GestionDeFormations.Repositories;

import com.ipsas.GestionDeFormations.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
