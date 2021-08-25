package com.isa.security.dto;

import com.isa.user.domain.enumeration.Role;

public class UserTokenState {

    private String token;
    private long expiresIn;
    private Role role;
    private Long userId;

    public UserTokenState() {
    }

    public UserTokenState(String token, long expiresIn, Role role, Long userId) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.role = role;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
