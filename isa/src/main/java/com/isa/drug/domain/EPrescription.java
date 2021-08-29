package com.isa.drug.domain;

import com.isa.drug.domain.enums.EPrescriptionStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class EPrescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private Date date;

    @Column
    private EPrescriptionStatus status;

    @OneToMany
    private List<Prescription> prescription;

    //TODO Add patient

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EPrescriptionStatus getStatus() {
        return status;
    }

    public void setStatus(EPrescriptionStatus status) {
        this.status = status;
    }

    public List<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<Prescription> prescription) {
        this.prescription = prescription;
    }
}
