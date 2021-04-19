package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Enums.Role;
import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Models.Student;
import com.ipsas.GestionDeFormations.Models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserService userService;
    private StudentService studentService;
    private GroupeService groupeService;
    private MatiereService matiereService;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserService userService,GroupeService groupeService,MatiereService matiereService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.groupeService = groupeService;
        this.matiereService = matiereService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        Student s = new Student("Skander","Hadjkacem","skanderhk",passwordEncoder.encode("12325135"),"skanderhkacem@gmail.com","www.bootdey.com/img/Content/avatar/avatar3.png", Role.STUDENT);
        List<Student> studentList = Arrays.asList(s);
        this.studentService.addStudents(studentList);
        Groupe groupe1 = new Groupe("GINF");
        Groupe groupe2 = new Groupe("GCIV");
        List<Groupe> groupes = Arrays.asList(groupe1,groupe2);
        this.groupeService.addGroupes(groupes);
        Matiere m1 = new Matiere("Anglais 1",15);
        Matiere m2 = new Matiere("Technique de communications",15);
        Matiere m3 = new Matiere("Development BACK-END",30);
        List<Matiere> matieres = Arrays.asList(m1,m2,m3);
        this.matiereService.addMatieres(matieres);
    }
}
