package com.intellisensedev.urlshortener_engine.controller;

import com.intellisensedev.urlshortener_engine.dto.UserDto;
import com.intellisensedev.urlshortener_engine.service.ShortenURLService;
import com.intellisensedev.urlshortener_engine.service.UserService;
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

    private static final java.util.logging.Logger logger = Logger.getLogger(ShortenURLService.class.getName());


    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(){
        return "user/register";
    }

    @RequestMapping(value = "/user/success", method = RequestMethod.GET)
    public String success(){
        return "user/success";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("userDTO") UserDto userDto, Model model, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

        //This call the service method to create userDTO
        String userDTO = userService.createNewUserAccount(userDto);

        if (bindingResult.hasErrors()) {
            //return if there is error
            //logger.info("Error! {}", bindingResult);
        }

        if (userDTO != null) {
            //if user data is not empty give a successful message
            redirectAttributes.addFlashAttribute("successMssg", "user is Added Successfully.");
            model.addAttribute(userDTO);
            return "redirect:success";
        } else {
            model.addAttribute("errorMssg", "user is not Added Successfully, Please Try Again!");
            model.addAttribute("userDto", userDto);
            return "user/register";
        }

    }

    @RequestMapping(value = "/developer", method = RequestMethod.GET)
    public String developer(){
        return "about/developer";
    }




}
