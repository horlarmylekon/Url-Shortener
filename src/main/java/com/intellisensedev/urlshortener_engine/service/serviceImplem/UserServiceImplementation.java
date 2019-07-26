package com.intellisensedev.urlshortener_engine.service.serviceImplem;

import com.intellisensedev.urlshortener_engine.dto.UserDto;
import com.intellisensedev.urlshortener_engine.model.User;
import com.intellisensedev.urlshortener_engine.repository.UserRepository;
import com.intellisensedev.urlshortener_engine.service.ShortenURLService;
import com.intellisensedev.urlshortener_engine.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    private static final java.util.logging.Logger logger = Logger.getLogger(ShortenURLService.class.getName());



    @Override
    public String createNewUser(UserDto userDto) {
        //check if the same user with same is not present
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            logger.info("User with same email already exists");
            return "User Exists";
            //return MessageSource.getMessage('user.exists')
        }
        System.out.println(userDto.getName());
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getEmail());
        System.out.println(userDto.getPassword());
        System.out.println(userDto.getConfirmPassword());
        //now am mapping my UserDto to model
        User user = modelMapper.map(userDto, User.class);


        try{
            //save
            userRepository.save(user);
            return "User created successfully";
            //return MessageSource.getMessage('user.create.success')
        }catch (Exception ex){
            logger.log(Level.SEVERE, "On creating user", ex);
            return "Error creating user";
            //return MessageSource.getMessage('user.create.error')
        }
    }
}
