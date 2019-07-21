package com.intellisensedev.urlshortener_engine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

@Controller
public class ShortenURLController {


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String urlShortnerView() {
        return "index";
    }



}
