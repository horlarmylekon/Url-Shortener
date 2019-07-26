package com.intellisensedev.urlshortener_engine.service.serviceImplem;

import com.intellisensedev.urlshortener_engine.dto.UserDto;
import com.intellisensedev.urlshortener_engine.model.ShortenURL;
import com.intellisensedev.urlshortener_engine.model.User;
import com.intellisensedev.urlshortener_engine.repository.UserRepository;
import com.intellisensedev.urlshortener_engine.service.ShortenURLService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ShortenURLServiceImplementation implements ShortenURLService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    private static final Logger logger = Logger.getLogger(ShortenURLService.class.getName());

    @Override
    public String createShortenURL(String longUrl) {

        // use murmurhash
        return null;
    }

    public void validateUrl(String long_url){
        // takes user long url to check if it a
        // valid url.
    }

    public String generateShortURL(String longUrl){
        String randomStr = "";


        return randomStr;
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
