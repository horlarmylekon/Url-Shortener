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
    public String createNewUserAccount(UserDto userDto) {
        //check if the same user with same is not present
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            logger.info("User with same email already exists");
            return "user already exist";
            //return MessageSource.getMessage('user.exists')
        }

        logger.info("GOT HERE");
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

    @Override
    public String deleteUserAccount(Long id) {

        User user = userRepository.findUserByUserID(id);

        logger.info("Attempting to delete user: ");
        try{
            //delete user account
            userRepository.delete(user);
            logger.info("User with email" + user.getEmail() + " is deleted successfully");
            return "User deleted successfully";
            //return MessageSource.getMessage('user.delete.success')
        }catch (Exception e){
            logger.log(Level.SEVERE, "On deleting user", e);
            return "Error deleting user";
            //return MessageSource.getMessage('user.delete.error')
        }
    }
}
