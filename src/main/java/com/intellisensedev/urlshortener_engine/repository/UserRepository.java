package com.intellisensedev.urlshortener_engine.repository;

import com.intellisensedev.urlshortener_engine.model.User;
import com.intellisensedev.urlshortener_engine.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findByUsername(String username);

    User findUserByEmail(String email);

    boolean existsByUsername(String superadmin);

    User findUserByUserID(Long id);

    String findByUserType(UserType userType);

    void delete(User user);
}
