package com.isa.systemAdmin.domain;

import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.Patient;
import com.isa.user.domain.Pharmacist;

import javax.persistence.*;
import java.util.Date;

public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String text;
    private boolean answered;
    private Patient patient;
    private Pharmacist pharmacist;
    private Dermatologist dermatologist;
    //add Pharmacy


    public Complaint() {}

    public Complaint(Long id, Date date, String text, boolean answered, Patient patient, Pharmacist pharmacist) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.answered = answered;
        this.patient = patient;
        this.pharmacist = pharmacist;
    }

    public Complaint(Long id, Date date, String text, boolean answered, Patient patient, Dermatologist dermatologist) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.answered = answered;
        this.patient = patient;
        this.dermatologist = dermatologist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }
}
