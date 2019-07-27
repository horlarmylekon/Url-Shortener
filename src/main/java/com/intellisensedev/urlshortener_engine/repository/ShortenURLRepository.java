package com.intellisensedev.urlshortener_engine.repository;

import com.intellisensedev.urlshortener_engine.model.ShortenURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortenURLRepository extends JpaRepository<ShortenURL, Long> {
}
