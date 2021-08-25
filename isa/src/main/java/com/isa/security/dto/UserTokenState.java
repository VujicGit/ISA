package com.isa.security.dto;

public class UserTokenState {

    private String token;
    private int expiresIn;

    public UserTokenState() {
    }

    public UserTokenState(String token, int expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
