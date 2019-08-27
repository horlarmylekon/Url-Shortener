package com.intellisensedev.urlshortener_engine.urlapp.services.serviceImplementation;

import com.intellisensedev.urlshortener_engine.urlapp.dtos.AdminDto;
import com.intellisensedev.urlshortener_engine.urlapp.models.Admin;
import com.intellisensedev.urlshortener_engine.role.repository.RoleRepository;
import com.intellisensedev.urlshortener_engine.urlapp.repositories.AdminRepository;
import com.intellisensedev.urlshortener_engine.urlapp.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AdminServiceImplementation implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final java.util.logging.Logger logger = Logger.getLogger(AdminServiceImplementation.class.getName());



    @Override
    public String createNewAdminUser(AdminDto adminDto) {
        //check if the same admin with same is not present
        Admin admin = adminRepository.findAdminByEmail(adminDto.getEmail());

        if(admin != null){
            logger.info("Admin with same email already exists");
            return "admin already exist";
            //return MessageSource.getMessage('admin.exists')
        }

        logger.info("Instatiating Creation of Admin User ...");
        //now am mapping my AdminDto to models
        admin = modelMapper.map(adminDto, Admin.class);


        try{
            //save
            adminRepository.save(admin);
            return "Admin created successfully";
            //return MessageSource.getMessage('admin.create.success')
        }catch (Exception ex){
            logger.log(Level.SEVERE, "On creating admin", ex);
            return "Error creating admin";
            //return MessageSource.getMessage('admin.create.error')
        }
    }

    @Override
    public String deleteAdminUser(Long id) {

        Admin admin = adminRepository.findByAdminID(id);

        logger.info("Attempting to delete admin: ");
        try{
            //delete admin account
            adminRepository.delete(admin);
            logger.info("Admin with email" + admin.getEmail() + " is deleted successfully");
            return "Admin deleted successfully";
            //return MessageSource.getMessage('admin.delete.success')
        }catch (Exception e){
            logger.log(Level.SEVERE, "On deleting admin", e);
            return "Error deleting admin";
            //return MessageSource.getMessage('admin.delete.error')
        }
    }

    @Override
    public void save(Admin admin) {
        admin.setPassword(admin.getPassword());
        admin.setRole(admin.getRole());
        adminRepository.save(admin);
    }


    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
