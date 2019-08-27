package com.intellisensedev.urlshortener_engine.role.repository;

import com.intellisensedev.urlshortener_engine.role.model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permissions, Long> {
    Permissions findByName(String privilege);
}
