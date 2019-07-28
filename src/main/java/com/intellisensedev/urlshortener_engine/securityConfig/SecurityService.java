package com.intellisensedev.urlshortener_engine.securityConfig;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
