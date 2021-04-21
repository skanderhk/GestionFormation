package com.ipsas.GestionDeFormations.Enums;

public enum Permissons {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write");

    private final String permissions;


    Permissons(String permissions) {
        this.permissions = permissions;
    }
}
