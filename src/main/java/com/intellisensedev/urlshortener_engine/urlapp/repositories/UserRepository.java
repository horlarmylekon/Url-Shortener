package com.intellisensedev.urlshortener_engine.urlapp.repositories;

import com.intellisensedev.urlshortener_engine.urlapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
