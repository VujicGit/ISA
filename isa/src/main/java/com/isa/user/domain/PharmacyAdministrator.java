package com.isa.user.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.*;

@Entity
public class PharmacyAdministrator extends User {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Pharmacy pharmacy;

    public PharmacyAdministrator() {}

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
