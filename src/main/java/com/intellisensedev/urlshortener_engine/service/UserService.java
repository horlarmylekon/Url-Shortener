package com.intellisensedev.urlshortener_engine.service;

import com.intellisensedev.urlshortener_engine.dto.UserDto;


public interface UserService {
    /**
     * create a new user
     * @param userDto
     * @return
     */
    String createNewUserAccount(UserDto userDto);

    /**
     * delete user
     * @param id
     * @return
     */
    String deleteUserAccount(Long id);
}
