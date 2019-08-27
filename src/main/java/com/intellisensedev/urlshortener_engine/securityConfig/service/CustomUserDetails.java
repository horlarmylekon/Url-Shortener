package com.intellisensedev.urlshortener_engine.securityConfig.service;

import com.intellisensedev.urlshortener_engine.urlapp.models.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private Admin adminUser;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //constructor w
    public CustomUserDetails(Admin loggedInUser) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        logger.info("initializing available roles with corresponding permissions");

        final List<GrantedAuthority> authorities = new ArrayList<>();

        //add permissions to user
        adminUser.getRole().getPermissions().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));
        authorities.add(new SimpleGrantedAuthority(adminUser.getRole().toString()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return adminUser.getPassword();
    }

    @Override
    public String getUsername() {
        return adminUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Admin getUserDetails() {
        return adminUser;
    }
}
