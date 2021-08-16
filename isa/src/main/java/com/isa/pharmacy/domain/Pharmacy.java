
package com.isa.pharmacy.domain;

import com.isa.user.domain.Address;
import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.Pharmacist;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "pharmacys_dermatolostist",
            joinColumns = @JoinColumn(name = "pharmacy_id"),
            inverseJoinColumns = @JoinColumn(name = "dermatologist_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Dermatologist> dermatologists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pharmacy")
    private List<Pharmacist> pharmacists;

    @OneToOne(fetch = FetchType.LAZY, cascade = {})
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Warehouse warehouse;

    @OneToOne(fetch = FetchType.LAZY)
    private Pricelist priceList;


    public Pharmacy(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Pharmacy() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dermatologist> getDermatologists() {
        return dermatologists;
    }

    public void setDermatologists(List<Dermatologist> dermatologists) {
        this.dermatologists = dermatologists;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Pricelist getPriceList() {
        return priceList;
    }

    public void setPriceList(Pricelist priceList) {
        this.priceList = priceList;
    }




}
