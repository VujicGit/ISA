package com.isa.pharmacy.domain;

import com.isa.appointment.domain.Appointment;
import com.isa.drug.domain.Drug;
import com.isa.patient.domain.AppointmentReport;

import javax.persistence.*;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private PriceList priceList;

    //TimePeriod

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Drug drug;

    public Price(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }


}
