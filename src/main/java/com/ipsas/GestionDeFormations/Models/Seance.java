package com.ipsas.GestionDeFormations.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private double duree;
    private String description;
    @OneToMany
    private List<FichePresence> listFichePresence;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JsonIgnoreProperties(value = {"listSeance"})
    private Matiere matiere;

    @ManyToOne
    private Groupe groupe;

    public Seance(LocalDate date, double duree, String description, List<FichePresence> listFichePresence, Matiere matiere, Groupe groupe) {
        this.date = date;
        this.duree = duree;
        this.description = description;
        this.listFichePresence = new ArrayList<>();
        this.matiere = matiere;
        this.groupe = groupe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Seance() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FichePresence> getListFichePresence() {
        return listFichePresence;
    }

    public void setListFichePresence(List<FichePresence> listFichePresence) {
        this.listFichePresence = listFichePresence;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public void addFichePresence(FichePresence fichePresence) {
        Student student = fichePresence.getStudent();

        for (FichePresence fiche:listFichePresence) {
            if (fiche.getStudent() == student){
                throw new RuntimeException("Fiche Presance of Student "+student.getFirstname()+" is already exist");
            }
        }
        this.listFichePresence.add(fichePresence);
    }

}
