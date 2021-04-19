package com.ipsas.GestionDeFormations.Models;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double noteDS;
    private double noteExam;
    private double moyenne;
    @OneToOne
    @JoinColumn(name="nm_fk",referencedColumnName = "id")
    private Matiere matiere;
    @OneToOne
    @JoinColumn(name="ns_fk",referencedColumnName = "id")
    private User user;

    public Note(double noteDS, double noteExam, Matiere matiere, User user) {
        this.noteDS = noteDS;
        this.noteExam = noteExam;
        this.moyenne = this.noteDS*0.4+this.noteExam*0.6;
        this.matiere = matiere;
        this.user = user;
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNoteDS() {
        return noteDS;
    }

    public void setNoteDS(double noteDS) {
        this.noteDS = noteDS;
    }

    public double getNoteExam() {
        return noteExam;
    }

    public void setNoteExam(double noteExam) {
        this.noteExam = noteExam;
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

    public User getStudent() {
        return user;
    }

    public void setStudent(User user) {
        this.user = user;
    }
}
