package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class DbInit implements CommandLineRunner {
    private UserService userService;
    private NoteService noteService;
    private StudentService studentService;
    private MatiereService matiereService;
    private GroupeService groupeService;
    private PasswordEncoder passwordEncoder;
    private AdminService adminService;
    private EmployeeService employeeService;

    public DbInit(UserService userService, NoteService noteService, StudentService studentService, MatiereService matiereService, GroupeService groupeService, PasswordEncoder passwordEncoder, AdminService adminService, EmployeeService employeeService) {
        this.userService = userService;
        this.noteService = noteService;
        this.studentService = studentService;
        this.matiereService = matiereService;
        this.groupeService = groupeService;
        this.passwordEncoder = passwordEncoder;
        this.adminService = adminService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) {
        Student s = new Student("Skander","hkacem","skanderhk", passwordEncoder.encode("12325135"),"skander@gmail.com","https://bootdey.com/img/Content/avatar/avatar1.png");
        Groupe g = new Groupe("GINF");
        this.groupeService.addGroupe(g);
        this.studentService.addStudent(s);
        this.studentService.joinGroupe(s,g);
        Matiere m1 = new Matiere(30,"Math");
        Matiere m2 = new Matiere(15,"INFO");
        List<Matiere> listMatieres = Arrays.asList(m1,m2);
        this.matiereService.addMatieres(listMatieres);
        Admin a = new Admin("Super","Admin","admin", passwordEncoder.encode("12325135"),"admin@gmail.com", "https://bootdey.com/img/Content/avatar/avatar1.png");
        this.adminService.addAdmin(a);
        Employee e = new Employee("Ahmed","Jmal","ahmed", passwordEncoder.encode("123456"),"ahmed@gmail.com","https://bootdey.com/img/Content/avatar/avatar3.png");
        this.employeeService.addEmployee(e);
        this.matiereService.addToGroupe(m1,g);
        Note note = new Note(15,12,m1,s);
        this.noteService.addNote(note);
    }
}
