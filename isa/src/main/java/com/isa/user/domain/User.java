package com.isa.user.domain;

import com.isa.user.domain.enumeration.Gender;
import com.isa.user.domain.enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String identificationNumber;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Gender gender;

    @Column
    private String password;

    @Column
    private boolean verified;

    @Column
    private Role role;

    @Column
    private boolean passwordChanged;

    @Column
    @NotNull
    private boolean firstTimeLoggedIn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
    )
    private List<Authority> authorities;


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
        this.firstTimeLoggedIn = false;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public boolean getIsFirstTimeLoggedIn() {
        return firstTimeLoggedIn;
    }

    public void setFirstTimeLoggedIn(boolean firstTimeLoggedIn) {
        this.firstTimeLoggedIn = firstTimeLoggedIn;
    }
}
