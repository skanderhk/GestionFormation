package com.ipsas.GestionDeFormations.Models;

import javax.persistence.*;

@Entity
public class FichePresence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Student student;
    private boolean presence;

    public FichePresence(Student student, boolean presence) {
        super();
        this.student = student;
        this.presence = presence;
    }

    public FichePresence() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
