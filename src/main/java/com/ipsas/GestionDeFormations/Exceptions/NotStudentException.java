package com.ipsas.GestionDeFormations.Exceptions;

import com.ipsas.GestionDeFormations.Models.Groupe;

public class NotStudentException extends RuntimeException {
    public NotStudentException(String s) {
        super(s);
    }
}
