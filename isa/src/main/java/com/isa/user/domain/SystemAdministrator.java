package com.isa.user.domain;

import com.isa.user.domain.enumeration.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.SYSTEM_ADMINISTRATOR)
public class SystemAdministrator extends User{

    public SystemAdministrator() {}
}
