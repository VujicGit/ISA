package com.isa.user.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.*;

@Entity
public class PharmacyAdministrator extends User {

    public Long getPharmacyId() {
        return pharmacyId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @Column(name = "pharmacy_id", insertable = false, updatable = false)
    private Long pharmacyId;

    public PharmacyAdministrator() {}

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
