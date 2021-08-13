package com.isa.pharmacy.domain;

import com.isa.appointment.domain.Appointment;
import com.isa.appointment.domain.TimePeriod;
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

    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "priceStartTime")),
            @AttributeOverride( name = "end", column = @Column(name = "priceEndTime"))
    })
    TimePeriod priceTime;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Drug drug;

    public Price(Double price, Drug drug){
        this.price = price;

        this.drug = drug;
    }

    public Price() {}

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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public TimePeriod getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(TimePeriod priceTime) {
        this.priceTime = priceTime;
    }
}
