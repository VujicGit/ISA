package com.isa.loyaltyAndPromotions.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Patient;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {})
    List<Patient> patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    Pharmacy pharmacy;

    public Subscription() {

    }

    public Subscription( List<Patient> patient, Pharmacy pharmacy) {
        this.patient = patient;
        this.pharmacy = pharmacy;
    }

    public Long getId() {
        return id;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
