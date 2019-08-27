package com.intellisensedev.urlshortener_engine.urlapp.dtos;

import java.util.Date;

public class UrlDTO {

    private Long id;
    private String longURL;
    private String customURL;
    private Date dateCreated;
    private Date expirationDate;

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
