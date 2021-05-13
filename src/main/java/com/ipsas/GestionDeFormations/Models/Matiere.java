package com.ipsas.GestionDeFormations.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    private double volumeHoraire;
    private String libelle;
    private double nombreHeureEnseigne;

    @OneToMany(mappedBy = "matiere",cascade = {CascadeType.MERGE})
    @JsonIgnoreProperties(value = {"matiere","groupe"})
    private List<Seance> listSeance;

    @ManyToMany(fetch = FetchType.EAGER ,mappedBy = "matieresList",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnoreProperties(value = "matieresList")
    private List<Groupe> groupeList = new ArrayList<>();


    public Matiere(double volumeHoraire, String libelle) {
        this.volumeHoraire = volumeHoraire;
        this.libelle = libelle;
        this.nombreHeureEnseigne = 0;
        this.listSeance = listSeance;
        this.groupeList = groupeList;
    }

    public Matiere() {

    }

    public double getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(double volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getNombreHeureEnseigne() {
        return nombreHeureEnseigne;
    }

    public void setNombreHeureEnseigne(double nombreHeureEnseigne) {
        if (this.volumeHoraire > nombreHeureEnseigne) {
            this.nombreHeureEnseigne = nombreHeureEnseigne;
        }
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", volumeHoraire=" + volumeHoraire +
                ", libelle='" + libelle + '\'' +
                ", nombreHeureEnseigne=" + nombreHeureEnseigne +
                ", listSeance=" + listSeance +
                ", groupeList=" + groupeList +
                '}';
    }

    public void addNombreHeureEnseigne(double nombreHeure) {
        double totalNombreHeure = this.nombreHeureEnseigne + nombreHeure;
        setNombreHeureEnseigne(totalNombreHeure);
    }

    public List<Seance> getListSeance() {
        return listSeance;
    }

    public void setListSeance(List<Seance> listSeance) {
        this.listSeance = listSeance;
    }

    public void addSeance(Seance seance) {
        this.listSeance.add(seance);
    }

    public List<Groupe> getGroupeList() {
        return groupeList;
    }

    public void setGroupeList(List<Groupe> groupeList) {
        this.groupeList = groupeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
