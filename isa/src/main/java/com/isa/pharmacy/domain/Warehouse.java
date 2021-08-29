package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Item> items;

    public Warehouse(){}

    public Warehouse(Pharmacy pharmacy, List<Item> items) {
        this.pharmacy = pharmacy;
        this.items = items;
    }
    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

