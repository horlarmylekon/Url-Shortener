package com.intellisensedev.urlshortener_engine.service;

import com.intellisensedev.urlshortener_engine.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
    /**
     * create a new user
     * @param userDto
     * @return
     */
    String createNewUser(UserDto userDto);
}
