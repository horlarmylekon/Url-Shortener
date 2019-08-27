package com.intellisensedev.urlshortener_engine.setup;

import com.intellisensedev.urlshortener_engine.role.model.Permissions;
import com.intellisensedev.urlshortener_engine.role.model.Roles;
import com.intellisensedev.urlshortener_engine.role.repository.PermissionRepository;
import com.intellisensedev.urlshortener_engine.urlapp.models.Admin;
import com.intellisensedev.urlshortener_engine.role.repository.RoleRepository;
import com.intellisensedev.urlshortener_engine.urlapp.repositories.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class SetupConfiguration implements CommandLineRunner {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void run(String... args) throws Exception {


        if(adminRepository.count() == 0){
            initPrivileges();
            initRole();
            createDefaultSuperAdminRoleAndUser();
        }
    }

    @Transactional
    public void createDefaultSuperAdminRoleAndUser(){

        try{
            Roles adminRole = roleRepository.findByName("ADMIN");

            logger.info("Creating a admin user");
            Admin adminUser = new Admin();
            adminUser.setFirstName("Test");
            adminUser.setLastName("Test");
            adminUser.setEmail("oyeknamiakandeworld@gmail.com");
            adminUser.setUsername("test");
            adminUser.setPassword(bCryptPasswordEncoder.encode("password"));
            adminUser.setAddresse("173, Test Road.");
            adminUser.setPassword("08107910212");
            adminUser.setRole(adminRole);

            adminRepository.save(adminUser);

            logger.info("Super admin users created");

        }catch (Exception e){
            logger.error("Failed to create super admin", e);
        }
    }

    private void initRole() {

        final Permissions permissions1 = permissionRepository.findByName("CREATE_USER_PRIVILEGE");
        final Permissions permissions2 = permissionRepository.findByName("DELETE_USER_PRIVILEGE");
        final Permissions permissions3 = permissionRepository.findByName("CREATE_CUSTOM_URL");

        //create an admin role
        final Roles roles1 = new Roles();
        roles1.setName("ADMIN");
        roles1.setPermissions(new HashSet<>(Arrays.asList(permissions1, permissions2)));
        roleRepository.save(roles1);

        final Roles roles2 = new Roles();
        roles2.setName("USER");
        roles2.setPermissions(new HashSet<>(Arrays.asList(permissions3)));
        roleRepository.save(roles2);

    }

    private void initPrivileges() {

        final Permissions permissions1 = new Permissions();
        permissions1.setName("CREATE_USER_PRIVILEGE");
        permissionRepository.save(permissions1);
        //
        final Permissions permissions2 = new Permissions();
        permissions2.setName("DELETE_USER_PRIVILEGE");
        permissionRepository.save(permissions2);

        final Permissions permissions3 = new Permissions();
        permissions3.setName("CREATE_CUSTOM_URL");
        permissionRepository.save(permissions3);
    }

}
