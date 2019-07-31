package com.intellisensedev.urlshortener_engine.setup;

import com.intellisensedev.urlshortener_engine.model.Role;
import com.intellisensedev.urlshortener_engine.model.User;
import com.intellisensedev.urlshortener_engine.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetupConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void run(String... args) throws Exception {
        //check if the program should create a default
        //super admin user
        if(shouldCreateDefaultSuperAdmin()){
            //if not
            createDefaultSuperAdminRoleAndUser();
        }
    }

    private boolean shouldCreateDefaultSuperAdmin(){

        logger.info("Checking if super admin user should be created");
        // check if a user with username superadmin is present
        boolean superAdminExists = userRepository.existsByUsername("superadmin");
        if(!superAdminExists){
            logger.info("Super admin will be created");
            return true;
        }
        logger.info("Super admin already exists");
        return false;
    }

    @Transactional
    public void createDefaultSuperAdminRoleAndUser(){

        logger.info("Creating a default super admin role and user");

        try{
            //User user = userRepository.findUserByRoles("SUPER_ADMIN");

//            if(user == null){
//                logger.info("No super admin user found, will try to create one");
//
//            }

            User adminUser = new User();
            adminUser.setName("superadmin");
            adminUser.setEmail("oyeknamiakandeworld@gmail.com");
            adminUser.setUsername("superadmin");
            //adminUser.setRoles();
            adminUser.setPassword("super");
            adminUser.setConfirmPassword("super");

            userRepository.save(adminUser);
            logger.info("Super admin users created");
        }catch (Exception e){
            logger.error("Failed to create super admin", e);
        }
    }

}
