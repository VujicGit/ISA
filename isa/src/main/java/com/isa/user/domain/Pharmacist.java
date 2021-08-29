package com.isa.user.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Warehouse;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.*;

@Entity
public class Pharmacist extends Employee{


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Pharmacy pharmacy;

    @Column
    private Double grade;

    public Pharmacist() {}

    public Pharmacist(Pharmacy pharmacy, Double grade) {
        this.pharmacy = pharmacy;
        this.grade = grade;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
