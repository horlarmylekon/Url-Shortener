package com.intellisensedev.urlshortener_engine.urlapp.services.serviceImplementation;

import com.google.common.hash.Hashing;
import com.intellisensedev.urlshortener_engine.urlapp.models.URL;
import com.intellisensedev.urlshortener_engine.urlapp.repositories.URLRepository;
import com.intellisensedev.urlshortener_engine.urlapp.services.URLService;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class URLServiceImplementation implements URLService {

    @Autowired
    private URLRepository urlRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String createShortURL(String longUrl) {

        UrlValidator urlValidator = new UrlValidator(new String[]{"http","https"});

        if (urlValidator.isValid(longUrl)){
            String header = "http://url.io/";
            //hash url
            String id = Hashing.murmur3_32().hashString(longUrl, StandardCharsets.UTF_8).toString();

            URL url = new URL();
            url.setCustomURL(header.concat(id));
            // To do
            //url.setDateCreated();
            //url.setExpirationDate();
            urlRepository.save(url);
            logger.info("generate a custom url: " + url.getCustomURL());
            return id;
        }
        throw new RuntimeException("Invalid Url "+ longUrl);
    }
}
