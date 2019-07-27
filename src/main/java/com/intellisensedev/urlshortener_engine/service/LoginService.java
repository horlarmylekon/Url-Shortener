/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intellisensedev.urlshortener_engine.service;

import org.springframework.stereotype.Service;

/**
 * @author intellisence
 */
@Service
public class LoginService {


    private String userEmail;


    private String password;

    public boolean login(String username, String password) {

        if (username.contentEquals(userEmail) && password.contentEquals(password)) {
            return true;
        }

        return false;

    }

}
