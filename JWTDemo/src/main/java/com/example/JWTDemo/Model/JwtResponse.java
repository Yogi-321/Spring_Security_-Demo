package com.example.JWTDemo.Model;

import org.springframework.stereotype.Component;

@Component
public class JwtResponse {

    String token;

    public JwtResponse() {
    }

    public String getToken() {
        return token;
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
