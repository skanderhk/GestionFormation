package com.ipsas.GestionDeFormations.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date date;
    private double duree;
    private String description;
    @OneToMany
    private List<FichePresence> listFichePresence;
    @ManyToOne
    private Matiere matiere;
    @ManyToOne
    private Groupe groupe;

    public Seance(Date date, double duree, String description, List<FichePresence> listFichePresence, Matiere matiere, Groupe groupe) {
        this.date = date;
        this.duree = duree;
        this.description = description;
        this.listFichePresence = listFichePresence;
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

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
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
        this.listFichePresence.add(fichePresence);
    }


}
