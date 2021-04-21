package com.ipsas.GestionDeFormations.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Libelle;
    @OneToMany(cascade = CascadeType.ALL)
    List<Student> StudentsList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    List<Matiere> matieresList = new ArrayList<>();

    public Groupe() {
    }

    public Groupe(String libelle) {
        Libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public List<Student> getStudentsList() {
        return StudentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        StudentsList = studentsList;
    }

    /* public List<Matiere> getMatieresList() {
        return matieresList;
    }

    public void setMatieresList(List<Matiere> matieresList) {
        this.matieresList = matieresList;
    }*/
}
