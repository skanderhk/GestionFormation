package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Enums.Role;
import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Student;
import com.ipsas.GestionDeFormations.Models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class DbInit implements CommandLineRunner {
    private UserService userService;
    private StudentService studentService;
    private GroupeService groupeService;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserService userService, StudentService studentService, GroupeService groupeService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.studentService = studentService;
        this.groupeService = groupeService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        Student s = new Student("Skander","hkacem","skanderhk", passwordEncoder.encode("12325135"),"skander@gmail.com","https://bootdey.com/img/Content/avatar/avatar1.png");
        Groupe g = new Groupe("GINF");
        this.groupeService.addGroupe(g);
        this.studentService.addStudent(s);
        this.studentService.joinGroupe(s,g);
    }
}
