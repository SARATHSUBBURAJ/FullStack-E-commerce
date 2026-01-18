package com.fullProject.demo.jwt.entity;

public class JwtResponse {

    private User user;
    private String JwtToken;

    public JwtResponse(User user, String jwtToken) {
        this.user = user;
        JwtToken = jwtToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return JwtToken;
    }

    public void setJwtToken(String jwtToken) {
        JwtToken = jwtToken;
    }
}
