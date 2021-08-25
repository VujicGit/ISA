package com.isa.user.dto;

public class JwtAuthenticationRequest {

    private String username;
    private String password;
    private Long pharmacyId;

    public JwtAuthenticationRequest() {

    }

    public JwtAuthenticationRequest(String username, String password, Long pharmacyId) {
        this.setUsername(username);
        this.setPassword(password);
        this.setPharmacyId(pharmacyId);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }
}
