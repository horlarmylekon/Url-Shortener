package com.intellisensedev.urlshortener_engine.configurattion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        //return bean
        return new ModelMapper();
    }


}
