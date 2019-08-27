package com.intellisensedev.urlshortener_engine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class UrlshortenerEngineApplication {

    //main method
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UrlshortenerEngineApplication.class, args);

//        String [] beanName = context.getBeanDefinitionNames();
//        Arrays.sort(beanName);
//        for (String names : beanName){
//            System.out.println(names);
//        }
    }

}
