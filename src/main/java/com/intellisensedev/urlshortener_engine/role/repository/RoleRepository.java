package com.intellisensedev.urlshortener_engine.role.repository;

import com.intellisensedev.urlshortener_engine.role.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Roles findByName(String name);


}
