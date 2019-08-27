package com.intellisensedev.urlshortener_engine.urlapp.services;

import com.intellisensedev.urlshortener_engine.urlapp.dtos.AdminDto;
import com.intellisensedev.urlshortener_engine.urlapp.models.Admin;


public interface AdminService {
    /**
     * create a new user
     * @param adminDto
     * @return
     */
    String createNewAdminUser(AdminDto adminDto);

    /**
     * delete user
     * @param id
     * @return
     */
    String deleteAdminUser(Long id);

    void save(Admin admin);

    Admin findByUsername(String username);
}
