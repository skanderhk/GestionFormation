package com.ipsas.GestionDeFormations.Models;

import com.ipsas.GestionDeFormations.Enums.Role;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Admin(String firstname, String lastname, String username, String password, String email, String profileImageUrl) {
        super(firstname, lastname, username, password, email, profileImageUrl, Role.ADMIN);
    }

    public Admin() {
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
