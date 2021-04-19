package com.ipsas.GestionDeFormations.Models;

import com.ipsas.GestionDeFormations.Enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("student")
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Groupe groupe;
    @OneToMany
    private List<Note> listNote;

    public Student() {

    }

    public Student(String firstname, String lastname, String username, String password, String email, String profileImageUrl, Role role) {
        super(firstname, lastname, username, password, email, profileImageUrl, Role.STUDENT);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public List<Note> getListNote() {
        return listNote;
    }

    public void setListNote(List<Note> listNote) {
        this.listNote = listNote;
    }

    public void setStudentCode(String userCode) {
        this.setUserCode(userCode);
    }
}
