package com.ipsas.GestionDeFormations.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Libelle;

    @OneToMany(mappedBy = "groupe",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnore
    List<Student> StudentsList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "matiere_groupe", joinColumns = @JoinColumn(name = "matiere_id"),inverseJoinColumns = @JoinColumn(name = "groupe_id"))
    @JsonIgnoreProperties(value = "groupeList")
    List<Matiere> matieresList = new ArrayList<>();



    public Groupe() {
    }

    public Groupe(String libelle, List<Student> studentsList, List<Matiere> matieresList) {
        Libelle = libelle;
        StudentsList = studentsList;
        this.matieresList = matieresList;
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

    public List<Matiere> getMatieresList() {
        return matieresList;
    }

    public void setMatieresList(List<Matiere> matieresList) {
        this.matieresList = matieresList;
    }
}
