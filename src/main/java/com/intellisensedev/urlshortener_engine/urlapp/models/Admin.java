package com.intellisensedev.urlshortener_engine.urlapp.models;

import com.intellisensedev.urlshortener_engine.role.model.Roles;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "AUTH_ADMIN")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminID;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotNull
    @Column(name = "USERNAME", unique = true)
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ADDRESSE")
    private String addresse;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "NUM_OF_URL")
    private String numberOfUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private Roles role;

    @Column(name = "DATE_CREATED")
    private String dateCreated;

    @Column(name = "LOGGED_IN_DATE")
    private String loggedInDate;

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumberOfUrl() {
        return numberOfUrl;
    }

    public void setNumberOfUrl(String numberOfUrl) {
        this.numberOfUrl = numberOfUrl;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLoggedInDate() {
        return loggedInDate;
    }

    public void setLoggedInDate(String loggedInDate) {
        this.loggedInDate = loggedInDate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addresse='" + addresse + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", numberOfUrl='" + numberOfUrl + '\'' +
                ", role=" + role +
                ", dateCreated='" + dateCreated + '\'' +
                ", loggedInDate='" + loggedInDate + '\'' +
                '}';
    }
}
