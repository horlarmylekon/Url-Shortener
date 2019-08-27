package com.intellisensedev.urlshortener_engine.urlapp.models;

import javax.persistence.*;

@Entity
@Table(name = "URL")
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "LONG_URL")
    private String longURL;
    @Column(name = "CUSTOM_URL")
    private String customURL;
    @Column(name = "DATE_CREATED")
    private String dateCreated;
    @Column(name = "EXPIRATION_DATE")
    private String expirationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getCustomURL() {
        return customURL;
    }

    public void setCustomURL(String customURL) {
        this.customURL = customURL;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
