package com.intellisensedev.urlshortener_engine.service;

import com.intellisensedev.urlshortener_engine.dto.UserDto;
import com.intellisensedev.urlshortener_engine.model.User;

import java.util.Date;
import java.util.Timer;

public interface ShortenURLService {

    /**
     *
     * @param longUrl
     * @return
     */
    String createShortenURL(String longUrl);
    /**
     *
     * @param longUrl
     * @return
     */
    String createCustomURL(String longUrl);
    /**
     *
     * @param time
     * @return
     */
    Date setExpirationTimeForURL(String time);

}
