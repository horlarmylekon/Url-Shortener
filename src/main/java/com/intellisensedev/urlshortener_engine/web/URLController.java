package com.intellisensedev.urlshortener_engine.web;

import com.intellisensedev.urlshortener_engine.urlapp.dtos.UrlDTO;
import com.intellisensedev.urlshortener_engine.urlapp.services.URLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/url")
public class URLController {

    @Autowired
    private URLService urlService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/create/custom")
    public ModelAndView createShortUrl(@RequestParam(name = "longUrl") String url, ModelAndView modelAndView, UrlDTO urlDTO){

        String header = "http://url.io/";
        String customUrl = urlService.createShortURL(url);
        String longUrl = urlService.findTarget(customUrl);

        modelAndView.setViewName("index");
        modelAndView.addObject("longUrl", longUrl);
        modelAndView.addObject("customUrl",header.concat(customUrl));
        return modelAndView;

    }
}
