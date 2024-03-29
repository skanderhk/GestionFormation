package com.ipsas.GestionDeFormations.Repositories;

import com.ipsas.GestionDeFormations.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
