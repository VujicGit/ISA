package com.isa.pharmacy.domain;

import com.isa.appointment.domain.Appointment;
import com.isa.appointment.domain.TimePeriod;
import com.isa.drug.domain.Drug;
import com.isa.patient.domain.AppointmentReport;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Price can not be null")
    private Double price;

    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "priceStartTime")),
            @AttributeOverride( name = "end", column = @Column(name = "priceEndTime"))
    })
    @NotNull(message = "Price time can not be null")
    TimePeriod priceTime;

    @OneToOne(fetch = FetchType.LAZY)
    private Drug drug;

    public Price(Double price, Drug drug, TimePeriod priceTime){
        this.price = price;
        this.drug = drug;
        this.priceTime = priceTime;
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

    public boolean isEqualByDate(Price price) {
        return drug.equals(price.drug) && priceTime.equals(price.priceTime);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price priceObj = (Price) o;
        return drug.equals(priceObj.drug)
                && priceTime.getStart().toLocalDate().equals(priceObj.priceTime.getStart().toLocalDate())
                && priceTime.getEnd().toLocalDate().equals(priceObj.priceTime.getEnd().toLocalDate())
                && price.equals(priceObj.price);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, priceTime, drug);
    }
}
