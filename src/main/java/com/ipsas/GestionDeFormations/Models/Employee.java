package com.ipsas.GestionDeFormations.Models;

import com.ipsas.GestionDeFormations.Enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Matiere> listMatiere;
    @ManyToMany
    private List<Groupe> listGroupe;

    public Employee(String firstname, String lastname, String username, String password, String email, String profileImageUrl) {
        super(firstname, lastname, username, password, email, profileImageUrl, Role.EMPLOYEE);
        this.listMatiere = listMatiere;
        this.listGroupe = listGroupe;
    }

    public Employee() {
    }

    public List<Matiere> getListMatiere() {
        return listMatiere;
    }

    public void setListMatiere(List<Matiere> listMatiere) {
        this.listMatiere = listMatiere;
    }

    public List<Groupe> getListGroupe() {
        return listGroupe;
    }

    public void setListGroupe(List<Groupe> listGroupe) {
        this.listGroupe = listGroupe;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
