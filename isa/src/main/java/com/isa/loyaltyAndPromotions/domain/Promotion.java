package com.isa.loyaltyAndPromotions.domain;

import com.isa.appointment.domain.TimePeriod;
import com.isa.pharmacy.domain.Pharmacy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Description can not be null")
    String description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "promotionStart")),
            @AttributeOverride( name = "end", column = @Column(name = "PromotionEnd"))
    })
    @NotNull(message = "Promotion time period can not be null")
    TimePeriod timePeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Pharmacy can not be null")
    Pharmacy pharmacy;


    public Promotion() {

    }

    public Promotion(String description, TimePeriod timePeriod, Pharmacy pharmacy) {
        this.description = description;
        this.timePeriod = timePeriod;
        this.pharmacy = pharmacy;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
