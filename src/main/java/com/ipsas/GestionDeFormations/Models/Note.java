package com.ipsas.GestionDeFormations.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    private double noteDC;
    private double noteDS;
    private double moyenne;
    @OneToOne(targetEntity = Matiere.class,fetch = FetchType.EAGER)
    private Matiere matiere;
    @ManyToOne
    @JsonIgnore
    private Student student;

    public Note(double noteDC, double noteDS, Matiere matiere, Student student) {
        this.noteDC = noteDC;
        this.noteDS = noteDS;
        this.matiere = matiere;
        this.student = student;
        this.moyenne = updateMoyenne();
    }

    public Note() {
    }

    public double updateMoyenne() {
        return this.noteDC * 0.4 + this.noteDS * 0.6;
    }

    public double getNoteDC() {
        return noteDC;
    }

    public void setNoteDC(double noteDC) {
        this.noteDC = noteDC;
        this.moyenne = updateMoyenne();
    }

    public double getNoteDS() {
        return noteDS;
    }

    public void setNoteDS(double noteDS) {
        this.noteDS = noteDS;
        this.moyenne = updateMoyenne();
    }

    public double getMoyenne() {
        return moyenne;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
