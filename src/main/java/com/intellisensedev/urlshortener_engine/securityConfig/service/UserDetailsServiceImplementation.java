package com.intellisensedev.urlshortener_engine.securityConfig.service;

import com.intellisensedev.urlshortener_engine.urlapp.models.Admin;
import com.intellisensedev.urlshortener_engine.urlapp.repositories.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public UserDetails loadUserByUsername(String username) {

        // find admin by username
        Admin loggedInUser = adminRepository.findByUsername(username);

        if(loggedInUser == null){
            throw new UsernameNotFoundException("Admin not found.");
        }

        try {

            logger.info("loadUserByUsername() : {}", username);
            return new CustomUserDetails(loggedInUser);
        }catch (Exception e){
            return (UserDetails) e;
        }
    }
}
