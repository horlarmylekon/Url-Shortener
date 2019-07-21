package com.intellisensedev.urlshortener_engine.service.serviceImplem;

import com.intellisensedev.urlshortener_engine.service.ShortenURLService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShortenURLServiceImplementation implements ShortenURLService {


    @Override
    public String createShortenURL(String longUrl) {
        return null;
    }

    @Override
    public String createCustomURL(String longUrl) {
        return null;
    }

    @Override
    public Date setExpirationTimeForURL(String time) {
        return null;
    }
}
