package com.intellisensedev.urlshortener_engine.urlapp.repositories;

import com.intellisensedev.urlshortener_engine.urlapp.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String email);

    Admin findByAdminID(Long id);

    Admin findByUsername(String username);

    Admin findAdminByEmail(String email);

    boolean existsByUsername(String superadmin);

    void delete(Admin admin);

    Admin findAdminByRole(String super_admin);
}
