package com.isa.user.domain;

import com.isa.user.domain.enumeration.Gender;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String identificationNumber;
    private String email;
    private String phone;
    private Gender gender;
    private String password;
    private boolean verified;
    private Role role;
    private boolean passwordChanged;
    private Address address;

    public User() {}

    public User(Long id, String name, String surname, String identificationNumber, String email, String phone, Gender gender, String password, boolean verified, Role role, boolean passwordChanged, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.verified = verified;
        this.role = role;
        this.passwordChanged = passwordChanged;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
