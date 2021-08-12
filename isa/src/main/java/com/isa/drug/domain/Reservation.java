package com.isa.drug.domain;

import com.isa.drug.domain.enums.ReservationStatus;
import com.isa.user.domain.Patient;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer uniqueId;

    @Column
    private Date date;

    @Column
    private ReservationStatus status;

    @Column
    private Integer quantity;

    @Column
    private Date dueDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Drug drug;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Patient patient;

    public Reservation() {
    }

    public Reservation(Long id, Integer uniqueId, Date date, ReservationStatus status, Integer quantity, Date dueDate, Drug drug, Patient patient) {
        this.id = id;
        this.uniqueId = uniqueId;
        this.date = date;
        this.status = status;
        this.quantity = quantity;
        this.dueDate = dueDate;
        this.drug = drug;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
