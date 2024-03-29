package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Exceptions.MatiereNotFoundException;
import com.ipsas.GestionDeFormations.Models.Groupe;
import com.ipsas.GestionDeFormations.Models.Matiere;
import com.ipsas.GestionDeFormations.Models.Student;
import com.ipsas.GestionDeFormations.Repositories.MatiereRepository;
import com.ipsas.GestionDeFormations.Repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MatiereService {

    private final MatiereRepository matiereRepo;

    @Autowired
    public MatiereService(MatiereRepository matiereRepo) {
        this.matiereRepo = matiereRepo;
    }

    public Matiere addMatiere(Matiere E){
        return matiereRepo.save(E);
    }

    public List<Matiere> addMatieres(List<Matiere> userList){
        return matiereRepo.saveAll(userList);
    }

    public List<Matiere> findAll(){
        return matiereRepo.findAll();
    }

    public Matiere findOneById(Long id){
        return matiereRepo.findById(id).orElseThrow(()-> new MatiereNotFoundException("Matiere by id : "+id+" is not found !" ));
    }

    public Matiere updateMatiere(Matiere E){
        return matiereRepo.save(E);
    }

    public void deleteMatiere(Long id){
        matiereRepo.deleteById(id);
    }

    public Matiere addToGroupe(Matiere E, Groupe g){
        Matiere matiere = this.matiereRepo.getOne(E.getId());
        if (matiere != null) {
            g.getMatieresList().add(E);
            return matiereRepo.save(E);
        }
        else throw new MatiereNotFoundException("Matiere by id : "+E.getId()+" is not found !" );
    }

}