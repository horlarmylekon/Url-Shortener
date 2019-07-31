package com.intellisensedev.urlshortener_engine.service;

import com.intellisensedev.urlshortener_engine.dto.UserDto;
import com.intellisensedev.urlshortener_engine.model.User;


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

    void save(User user);

    User findByUsername(String username);
}
