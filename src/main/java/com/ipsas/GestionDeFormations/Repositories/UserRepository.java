package com.ipsas.GestionDeFormations.Repositories;

import com.ipsas.GestionDeFormations.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByUsername(String s);
}
