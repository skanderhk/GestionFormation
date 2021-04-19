package com.ipsas.GestionDeFormations.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private double nbrHeures;
    private double nbrHeureEnseigne;

    public Matiere(String libelle, double nbrHeures) {
        this.libelle = libelle;
        this.nbrHeures = nbrHeures;
        this.nbrHeureEnseigne = 0;
    }

    public Matiere() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(double nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public double getNbrHeureEnseigne() {
        return nbrHeureEnseigne;
    }

    public void setNbrHeureEnseigne(double nbrHeureEnseigne) {
        this.nbrHeureEnseigne = nbrHeureEnseigne;
    }
}
