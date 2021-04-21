package com.ipsas.GestionDeFormations.Repositories;

import com.ipsas.GestionDeFormations.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
