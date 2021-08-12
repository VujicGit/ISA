package com.isa.user.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Warehouse;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.*;

@Entity
public class Pharmacist extends Employee{


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Pharmacy pharmacy;

    public Pharmacist() {}

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
