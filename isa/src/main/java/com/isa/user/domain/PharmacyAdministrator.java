package com.isa.user.domain;

import com.isa.user.domain.enumeration.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.PHARMACY_ADMINISTRATOR)
public class PharmacyAdministrator extends User {
    //add pharmacy

    public PharmacyAdministrator() {}
}
