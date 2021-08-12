package com.isa.drug.domain;

import javax.persistence.*;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private EPrescription ePrescription;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Drug drug;

    public Prescription() {
    }

    public Prescription(Long id, Integer quantity, EPrescription ePrescription, Drug drug) {
        this.id = id;
        this.quantity = quantity;
        this.ePrescription = ePrescription;
        this.drug = drug;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public EPrescription getePrescription() {
        return ePrescription;
    }

    public void setePrescription(EPrescription ePrescription) {
        this.ePrescription = ePrescription;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
