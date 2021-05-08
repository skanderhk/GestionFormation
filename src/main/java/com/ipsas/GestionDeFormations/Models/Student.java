package com.ipsas.GestionDeFormations.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ipsas.GestionDeFormations.Enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "groupe_id",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"studentsList"})
    private Groupe groupe;
    @OneToMany
    private List<Note> listNote;

    public Student() {

    }

    public Student(String firstname, String lastname, String username, String password, String email, String profileImageUrl) {
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
}
