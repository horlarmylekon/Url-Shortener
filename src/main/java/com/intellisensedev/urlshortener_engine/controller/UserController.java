package com.intellisensedev.urlshortener_engine.controller;

import com.intellisensedev.urlshortener_engine.dto.UserDto;
import com.intellisensedev.urlshortener_engine.model.User;
import com.intellisensedev.urlshortener_engine.securityConfig.SecurityService;
import com.intellisensedev.urlshortener_engine.service.ShortenURLService;
import com.intellisensedev.urlshortener_engine.service.UserService;
import com.intellisensedev.urlshortener_engine.setup.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Logger;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    private static final java.util.logging.Logger logger = Logger.getLogger(ShortenURLService.class.getName());


    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("userDTO", new User());
        return "user/register";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userDTO") UserDto userDto, Model model, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

        userValidator.validate(userDto, bindingResult);
        //This call the service method to create userDTO
        //String userDTO = userService.createNewUserAccount(userDto);

        if (bindingResult.hasErrors()) {
            return "user/register";
            //logger.info("Error! {}", bindingResult);
        }

        userService.save(userDto);

        securityService.autoLogin(userDto.getUsername(), userDto.getConfirmPassword());

        return "redirect:/dashboard";

    }

    @RequestMapping(value = "/user/success", method = RequestMethod.GET)
    public String success(){
        return "user/success";
    }



    @RequestMapping(value = "/developer", method = RequestMethod.GET)
    public String developer(){
        return "about/developer";
    }




}
