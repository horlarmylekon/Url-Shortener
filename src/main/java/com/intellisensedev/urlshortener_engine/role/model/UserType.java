package com.intellisensedev.urlshortener_engine.role.model;


import java.util.Arrays;
import java.util.List;

public enum UserType {

    ADMIN("ADMIN"),
    USER("USER"),
    GUEST("GUEST");

    private String description;

    UserType(String description) {
        this.description = description;
    }

    public List<UserType> getRoleTypes(){
        return  Arrays.asList(UserType.values());
    }
}
