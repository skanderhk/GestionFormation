package com.ipsas.GestionDeFormations.Repositories;

import com.ipsas.GestionDeFormations.Models.FichePresence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichePresenceRepository extends JpaRepository<FichePresence, Long> {
}
