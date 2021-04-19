package com.ipsas.GestionDeFormations.Services;

import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Models.UserPrinciple;
import com.ipsas.GestionDeFormations.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = this.userRepository.findUsersByUsername(s);
        UserPrinciple UserPrinciple = new UserPrinciple(u);
        return UserPrinciple;
    }
}
