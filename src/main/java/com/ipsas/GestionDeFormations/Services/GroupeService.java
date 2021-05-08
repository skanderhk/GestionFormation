package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Enums.Role;
import com.ipsas.GestionDeFormations.Exceptions.GroupeNotFoundException;
import com.ipsas.GestionDeFormations.Exceptions.NotStudentException;
import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Models.Student;
import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {
    private final GroupeRepository groupeRepo;

    @Autowired
    public GroupeService(GroupeRepository groupeRepo) {
        this.groupeRepo = groupeRepo;
    }

    public Groupe addGroupe(Groupe E){
        return groupeRepo.save(E);
    }

    public List<Groupe> addGroupes(List<Groupe> groupeList){
        return groupeRepo.saveAll(groupeList);
    }

    public List<Groupe> findAll(){
        return groupeRepo.findAll();
    }

    public Groupe findOneById(Long id){
        return groupeRepo.findById(id).orElseThrow(()-> new GroupeNotFoundException("Groupe by id : "+id+" is not found !" ));
    }

    public Groupe updateGroupe(Groupe E){
        return groupeRepo.save(E);
    }

    public void deleteGroupe(Long id){
        groupeRepo.deleteById(id);
    }

    public Groupe addStudent(Student u, Groupe e) {
        if (!(u.getRole().equals(Role.STUDENT))) {
            throw new NotStudentException("Student : "+u.getFirstname()+" "+u.getLastname()+" is not a STUDENT");
        }
        e.getStudentsList().add(u);
        return groupeRepo.save(e);
    }

    public Groupe deleteStudent(Student u, Groupe g)  {
        if (!(u.getRole().equals(Role.STUDENT))) {
            throw new NotStudentException("Student : "+u.getFirstname()+" "+u.getLastname()+" is not a STUDENT");
        }
        g.getStudentsList().remove(u);
        return groupeRepo.save(g);
    }

   public Groupe addMatiereList(List<Matiere> matiereList, Groupe e) {
       for (Matiere m:matiereList) {
           e.getMatieresList().add(m);
       }
       return groupeRepo.save(e);
    }

    public Groupe deleteMatiere(Matiere m, Groupe g) {
        g.getMatieresList().remove(m);
        return groupeRepo.save(g);
    }
}
