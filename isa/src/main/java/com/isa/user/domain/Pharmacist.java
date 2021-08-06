package com.isa.user.domain;

import com.isa.user.domain.enumeration.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.PHARMACIST)
public class Pharmacist extends Employee{

    public Pharmacist() {}
}
