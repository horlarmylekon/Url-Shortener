package com.intellisensedev.urlshortener_engine.model;

public class User {

    private Long userID;
    private String name;
    private String email;
    private String contact;
    private int numberOfUrl;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getNumberOfUrl() {
        return numberOfUrl;
    }

    public void setNumberOfUrl(int numberOfUrl) {
        this.numberOfUrl = numberOfUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", numberOfUrl=" + numberOfUrl +
                '}';
    }
}
