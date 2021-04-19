package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Enums.Role;
import com.ipsas.GestionDeFormations.Exceptions.GroupeNotFoundException;
import com.ipsas.GestionDeFormations.Exceptions.NotStudentException;
import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Groupe addStudent(User u,Groupe e) {
        if (!(u.getRole().equals(Role.STUDENT))) {
            throw new NotStudentException("User : "+u.getFirstname()+" "+u.getLastname()+" is not a STUDENT");
        }
        List<User> userList = e.getStudentsList();
        userList.add(u);
        e.setStudentsList(userList);
        return groupeRepo.save(e);
    }

    public Groupe deleteStudent(User u, Groupe g)  {
        if (!(u.getRole().equals(Role.STUDENT))) {
            throw new NotStudentException("User : "+u.getFirstname()+" "+u.getLastname()+" is not a STUDENT");
        }
        List<User> userList = g.getStudentsList();
        userList.remove(u);
        g.setStudentsList(userList);
        return groupeRepo.save(g);
    }

    public Groupe addMatiere(Matiere m,Groupe e) {
        List<Matiere> matiereList = e.getMatieresList();
        matiereList.add(m);
        e.setMatieresList(matiereList);
        return groupeRepo.save(e);
    }

    public Groupe deleteMatiere(Matiere m, Groupe g) {
        List<Matiere> matiereList = g.getMatieresList();
        matiereList.remove(m);
        g.setMatieresList(matiereList);
        return groupeRepo.save(g);
    }
}
