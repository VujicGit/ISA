package com.isa.user.domain;

import com.isa.user.domain.enumeration.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.PATIENT)
public class Patient extends User{

    @Column
    private int penalties;
    //add allergies, eprescriptions

    public Patient() {}
}
