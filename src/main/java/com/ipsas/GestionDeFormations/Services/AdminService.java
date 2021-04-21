package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Exceptions.AdminNotFoundException;
import com.ipsas.GestionDeFormations.Models.*;
import com.ipsas.GestionDeFormations.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    private final AdminRepository adminRepo;

    @Autowired
    public AdminService(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin addAdmin(Admin E){
        E.setUserCode(UUID.randomUUID().toString());
        return adminRepo.save(E);
    }


    public List<Admin> addAdmins(List<Admin> adminList){
        for (Admin admin : adminList)
        {
            admin.setUserCode(UUID.randomUUID().toString());
        }
        return adminRepo.saveAll(adminList);
    }

    public List<Admin> findAll(){
        return adminRepo.findAll();
    }

    public Admin findOneById(Long id){
        return adminRepo.findById(id).orElseThrow(()-> new AdminNotFoundException("Admin by id : "+id+" is not found !" ));
    }

    public Admin updateAdmin(Admin E){
        return adminRepo.save(E);
    }

    public void deleteAdmin(Long id){
        adminRepo.deleteById(id);
    }

}
