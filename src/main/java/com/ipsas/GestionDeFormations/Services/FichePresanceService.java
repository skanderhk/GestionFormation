package com.ipsas.GestionDeFormations.Services;


import com.ipsas.GestionDeFormations.Exceptions.FichePresenceNotFoundException;
import com.ipsas.GestionDeFormations.Models.FichePresence;
import com.ipsas.GestionDeFormations.Repositories.FichePresenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichePresanceService {

    private final FichePresenceRepository fichePresanceRepo;

    @Autowired
    public FichePresanceService(FichePresenceRepository fichePresanceRepo) {
        this.fichePresanceRepo = fichePresanceRepo;
    }

    public FichePresence addFichePresence(FichePresence E){
        return fichePresanceRepo.save(E);
    }

    public List<FichePresence> addFichePresences(List<FichePresence> userList){
        return fichePresanceRepo.saveAll(userList);
    }

    public List<FichePresence> findAll(){
        return fichePresanceRepo.findAll();
    }

    public FichePresence findOneById(Long id){
        return fichePresanceRepo.findById(id).orElseThrow(()-> new FichePresenceNotFoundException("FichePresence by id : "+id+" is not found !" ));
    }

    public FichePresence updateFichePresence(FichePresence E){
        return fichePresanceRepo.save(E);
    }

    public void deleteFichePresence(Long id){
        fichePresanceRepo.deleteById(id);
    }

}