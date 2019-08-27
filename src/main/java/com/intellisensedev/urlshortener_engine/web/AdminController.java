package com.intellisensedev.urlshortener_engine.web;

import com.intellisensedev.urlshortener_engine.urlapp.models.Admin;
import com.intellisensedev.urlshortener_engine.urlapp.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("userDTO", new Admin());
        return "user/register";
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
