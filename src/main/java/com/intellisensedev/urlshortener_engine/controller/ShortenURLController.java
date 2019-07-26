package com.intellisensedev.urlshortener_engine.controller;

import com.intellisensedev.urlshortener_engine.model.ShortenURL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShortenURLController {

    private Map<String, ShortenURL> shortenUrlList = new HashMap<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String urlShortnerView() {
        return "index";
    }


    @RequestMapping(path = "/id", method = RequestMethod.GET)
    public String getUrl(@PathVariable String id){

        //return long url from the unique id
        return null;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String getShortUrl(String url){

        return null;
    }


    @RequestMapping(value = "/shortenurl", method = RequestMethod.POST)
    public ResponseEntity<Object> getShortenURL(@RequestBody ShortenURL shortenURL) throws MalformedURLException {

        String randomChar = generateRandomChars();
        setShortUrl(randomChar, shortenURL);
        return new ResponseEntity<Object>(shortenURL, HttpStatus.OK);
    }

    private void setShortUrl(String randomChar, ShortenURL shortenURL) throws MalformedURLException{
        shortenURL.setShort_url("http://url.io/s/"+ randomChar);
        shortenUrlList.put(randomChar, shortenURL);
    }

    @RequestMapping(value = "/s/{randomstring}", method = RequestMethod.GET)
    public void getFullURL(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException{
        response.sendRedirect(shortenUrlList.get(randomString).getLong_url());
    }

    public String generateRandomChars(){
        String randomStr = "";
        String possibleChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for(int i = 0; i <= 5; i++){
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        }
        return randomStr;
    }
}
