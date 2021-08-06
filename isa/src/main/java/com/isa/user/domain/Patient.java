package com.isa.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Patient extends User{

    @Column
    private int penalties;
    //add allergies, eprescriptions

    public Patient() {}
}
