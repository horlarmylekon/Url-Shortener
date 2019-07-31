/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intellisensedev.urlshortener_engine.controller;

import com.intellisensedev.urlshortener_engine.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author intellisense
 *
 * The login controller provide access to authorize
 * users to login to their dashboard
 */
//@CrossOrigin
@Controller
public class LoginController {


    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping({"/", "/home"})
    public String welcome(Model model) {
        logger.info("Welcome to url.io home page.");
        return "index";
    }


    @GetMapping("/user/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        logger.info("Got into Login Page");
        return "user/login";
    }


    @GetMapping(path = "/user/dashboard")
    public String dashboard() {
        logger.info("Got to User Dashboard");
        return "dashboard/profile";
    }

}
