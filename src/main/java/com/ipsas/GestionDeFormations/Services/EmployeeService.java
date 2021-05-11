package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Exceptions.EmployeeNotFoundException;
import com.ipsas.GestionDeFormations.Models.*;
import com.ipsas.GestionDeFormations.Repositories.EmployeeRepository;
import com.ipsas.GestionDeFormations.Repositories.MatiereRepository;
import com.ipsas.GestionDeFormations.Repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final SeanceRepository seanceRepo;
    private final MatiereRepository matiereRepo;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo, SeanceRepository seanceRepo, MatiereRepository matiereRepo) {
        this.employeeRepo = employeeRepo;
        this.seanceRepo = seanceRepo;
        this.matiereRepo = matiereRepo;
    }

    public Employee addEmployee(Employee E){
        E.setUserCode(UUID.randomUUID().toString());
        return employeeRepo.save(E);
    }


    public List<Employee> addEmployees(List<Employee> employeeList){
        for (Employee Employee : employeeList)
        {
            Employee.setUserCode(UUID.randomUUID().toString());
        }
        return employeeRepo.saveAll(employeeList);
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee findOneById(Long id){
        return employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee by id : "+id+" is not found !" ));
    }

    public Employee updateEmployee(Employee E){
        return employeeRepo.save(E);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

    public void addSeancePourMatiere(Matiere matiere, Seance seance) {
        Seance createdSeance = seanceRepo.save(seance);
        matiere.addSeance(createdSeance);
        matiereRepo.save(matiere);
    }

    public void addToMatiereList(Matiere matiere, Employee E) {
        E.getListMatiere().add(matiere);
        employeeRepo.save(E);
    }

    public void setNoteDC(Matiere matiere, Student student, double noteDC) {
        List<Note> noteList = student.getListNote();
        for (Note n:noteList) {
            if (n.getMatiere().equals(matiere)){
                n.setNoteDC(noteDC);
            }
        }
    }

    public void setNoteDS(Matiere matiere, Student student, double noteDS) {
        List<Note> noteList = student.getListNote();
        for (Note n:noteList) {
            if (n.getMatiere().equals(matiere)){
                n.setNoteDS(noteDS);
            }
        }
    }

    public void setFichePresencePourSeance(Seance seance,List<FichePresence> listFichePresence) {
    }

    public void getListSeancePourGroupeMatiere(Groupe groupe, Matiere matiere) {

    }

    public void addGroup(Employee e, Groupe g) {
        this.employeeRepo.save(e);
        e.getListGroupe().add(g);
        this.employeeRepo.save(e);
    }
}
