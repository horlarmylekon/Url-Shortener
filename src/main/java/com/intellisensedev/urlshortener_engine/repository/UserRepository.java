package com.intellisensedev.urlshortener_engine.repository;

import com.intellisensedev.urlshortener_engine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    User findUserByEmail(String email);

    boolean existsByUsername(String superadmin);

    User findUserByUserID(Long id);

    User findUserByRoles(String role);

    void delete(User user);
}
