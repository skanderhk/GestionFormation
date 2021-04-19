package com.ipsas.GestionDeFormations.Repositories;

import com.ipsas.GestionDeFormations.Models.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
}
