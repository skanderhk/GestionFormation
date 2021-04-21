package com.ipsas.GestionDeFormations.Enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.ipsas.GestionDeFormations.Enums.Permissons.*;

public enum Role {
    ADMIN(Sets.newHashSet(EMPLOYEE_READ,EMPLOYEE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    STUDENT(Sets.newHashSet(STUDENT_READ)),
    EMPLOYEE(Sets.newHashSet(EMPLOYEE_READ));

    private final Set<Permissons> permissons;

    Role(Set<Permissons> permissons) {
        this.permissons = permissons;
    }

    public Set<Permissons> getPermissons() {
        return permissons;
    }
}
