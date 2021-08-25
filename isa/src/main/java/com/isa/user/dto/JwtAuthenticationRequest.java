package com.isa.user.dto;

public class JwtAuthenticationRequest {

    private String email;
    private String password;
    private Long pharmacyId;

    public JwtAuthenticationRequest() {

    }

    public JwtAuthenticationRequest(String email, String password, Long pharmacyId) {
        this.setEmail(email);
        this.setPassword(password);
        this.setPharmacyId(pharmacyId);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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
