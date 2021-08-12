
package com.isa.pharmacy.domain;

import com.isa.appointment.domain.Appointment;
import com.isa.drug.domain.Drug;
import com.isa.user.domain.Address;
import com.isa.user.domain.Dermatologist;
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

    @OneToOne(fetch = FetchType.EAGER, cascade = {})
    private Address address;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Warehouse warehouse;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PriceList priceList;


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

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }




}
