package com.intellisensedev.urlshortener_engine.urlapp.services;

public interface URLService {

    String createShortURL(String longUrl);

    String findTarget(String customUrl);
}
