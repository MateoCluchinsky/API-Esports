package com.tuempresa.esports.security;

import com.tuempresa.esports.model.Manager;
import com.tuempresa.esports.repository.ManagerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ManagerRepository managerRepository;

    public CustomUserDetailsService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Manager no encontrado"));

        return new User(manager.getUsername(), manager.getPassword(), new ArrayList<>());
    }
}