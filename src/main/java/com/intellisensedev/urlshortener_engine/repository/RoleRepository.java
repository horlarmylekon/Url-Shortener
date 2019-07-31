package com.intellisensedev.urlshortener_engine.repository;

import com.intellisensedev.urlshortener_engine.model.Role;
import com.intellisensedev.urlshortener_engine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
