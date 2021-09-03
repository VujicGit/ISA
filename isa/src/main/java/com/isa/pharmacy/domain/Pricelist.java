package com.isa.pharmacy.domain;

import com.isa.appointment.domain.Appointment;
import com.isa.appointment.domain.TimePeriod;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Pricelist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Price> prices;

    @OneToOne(fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

    @AttributeOverrides({
            @AttributeOverride( name = "start", column = @Column(name = "vacationStart")),
            @AttributeOverride( name = "end", column = @Column(name = "vacationEnd"))
    })
    @NotNull(message = "Vacation tim period can not be null")
    private TimePeriod priceTime;

    public Pricelist(){}

    public Pricelist(List<Price> prices, Pharmacy pharmacy) {
        this.prices = prices;
        this.pharmacy = pharmacy;
    }

    public Pricelist(List<Price> prices) {
        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
