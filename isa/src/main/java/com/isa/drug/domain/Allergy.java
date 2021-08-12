package com.isa.drug.domain;

import com.isa.user.domain.Patient;

import javax.persistence.*;

@Entity
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Drug drug;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Patient patient;

    public Allergy() {
    }

    public Allergy(Long id, String name, Drug drug, Patient patient) {
        this.id = id;
        this.name = name;
        this.drug = drug;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
