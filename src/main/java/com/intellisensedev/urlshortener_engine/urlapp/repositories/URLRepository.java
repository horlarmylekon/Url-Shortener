package com.intellisensedev.urlshortener_engine.urlapp.repositories;

import com.intellisensedev.urlshortener_engine.urlapp.models.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
}
