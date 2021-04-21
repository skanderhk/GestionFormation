package com.ipsas.GestionDeFormations.Repositories;

import com.ipsas.GestionDeFormations.Models.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
