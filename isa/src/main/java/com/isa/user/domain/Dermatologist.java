package com.isa.user.domain;

import com.isa.user.domain.enumeration.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.DERMATOLOGIST)
public class Dermatologist extends Employee{

    public Dermatologist() {}
}
