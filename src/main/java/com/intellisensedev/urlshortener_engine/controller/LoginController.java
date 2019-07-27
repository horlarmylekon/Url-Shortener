/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intellisensedev.urlshortener_engine.controller;

import com.intellisensedev.urlshortener_engine.model.User;
import com.intellisensedev.urlshortener_engine.repository.UserRepository;
import com.intellisensedev.urlshortener_engine.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author intellisense
 */
@CrossOrigin
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @GetMapping(path = "/login")
//    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
//
//        boolean loggedIn = loginService.login(username, password);
//
//        return ResponseEntity.ok(loggedIn);
//
//    }

    @GetMapping(path = "/user/login")
    public String login() {
        return "user/login";
    }

    @PostMapping(path = "/login")
    public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password) {

        // validate username and password
        User user = userRepository.findUserByEmail(email);
        System.out.println(user.getEmail()+" "+user.getPassword());
        if(!(user.getEmail()==email) || !(user.getPassword()==password)){
            logger.info("Invalid user details or not register");
            return "login failed";
        }

        try{
            loginService.login(email, password);
            logger.info("User successfully login");
            return "redirect:dashboard/profile";
        }catch (Exception ex){
            logger.info("",ex);
        }
        return "Successfully logged in ..";
    }

//    @GetMapping(path = "/dashboard")
//    public String dashboard() {
//        return "dashboard";
//    }

}
