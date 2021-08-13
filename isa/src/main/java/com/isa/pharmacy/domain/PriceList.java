package com.isa.pharmacy.domain;

import com.isa.appointment.domain.Appointment;

import javax.persistence.*;
import java.util.List;

@Entity
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Price> prices;



    public PriceList(){}

    public PriceList(List<Price> prices) {
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
}
