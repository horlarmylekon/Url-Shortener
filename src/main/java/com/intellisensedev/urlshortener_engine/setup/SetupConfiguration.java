package com.intellisensedev.urlshortener_engine.setup;

import com.intellisensedev.urlshortener_engine.model.Role;
import com.intellisensedev.urlshortener_engine.model.User;
import com.intellisensedev.urlshortener_engine.model.UserType;
import com.intellisensedev.urlshortener_engine.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetupConfiguration implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        //check if the program should create a super admin user
        if(shouldCreateDefaultSuperAdmin()){
            createDefaultSuperAdminRoleAndUser();
        }
    }

    private boolean shouldCreateDefaultSuperAdmin(){

        logger.info("Checking if super admin user should be created");

        boolean superAdminExists = userRepository.existsByUsername("superadmin");
        if(!superAdminExists){
            logger.info("Super admin will be created");
            return true;
        }
        logger.info("Super admin already exists");
        return false;
    }

    @Transactional
    void createDefaultSuperAdminRoleAndUser(){

        logger.info("Creating default super admin role and user");

        try{
            String user = userRepository.findByUserType(UserType.ADMIN);

            if(user == null){
                logger.info("No super admin user found, will try to create one");

            }

            User adminUser = new User();
            adminUser.setName("superadmin");
            adminUser.setEmail("oyeknamiakandeworld@gmail.com");
            adminUser.setUsername("superadmin");
            //adminUser.setRoles(R);
            adminUser.setPassword("super");
            adminUser.setConfirmPassword("super");

            userRepository.save(adminUser);
            logger.info("Super admin users created");
        }catch (Exception e){
            logger.error("Failed to create super admin", e);
        }
    }

}
