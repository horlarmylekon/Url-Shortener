package com.intellisensedev.urlshortener_engine.model;


import java.util.Date;

public class ShortenURL {

    private Long id;
    private String long_url;
    private String short_url;
    private Date expirationTime;
    private Long userID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "ShortenURL{" +
                "id=" + id +
                ", long_url='" + long_url + '\'' +
                ", short_url='" + short_url + '\'' +
                ", expirationTime=" + expirationTime +
                ", userID=" + userID +
                '}';
    }
}
