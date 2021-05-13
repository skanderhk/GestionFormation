package com.ipsas.GestionDeFormations.Services;


import com.ipsas.GestionDeFormations.Exceptions.SeanceNotFoundException;
import com.ipsas.GestionDeFormations.Models.Seance;

import com.ipsas.GestionDeFormations.Repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {

    private final SeanceRepository seanceRepo;

    @Autowired
    public SeanceService(SeanceRepository seanceRepo) {
        this.seanceRepo = seanceRepo;
    }

    public Seance addSeance(Seance E){
        return seanceRepo.save(E);
    }

    public List<Seance> addSeances(List<Seance> userList){
        return seanceRepo.saveAll(userList);
    }

    public List<Seance> findAll(){
        return seanceRepo.findAll();
    }

    public Seance findOneById(Long id){
        return seanceRepo.findById(id).orElseThrow(()-> new SeanceNotFoundException("Seance by id : "+id+" is not found !" ));
    }

    public Seance updateSeance(Seance E){
        return seanceRepo.save(E);
    }

    public void deleteSeance(Long id){
        seanceRepo.deleteById(id);
    }

}