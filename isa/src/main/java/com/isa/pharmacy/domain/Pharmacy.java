
package com.isa.pharmacy.domain;

import com.isa.user.domain.Address;
import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.Pharmacist;
import com.isa.user.domain.Shift;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "dermatologist_pharmacies",
            joinColumns = @JoinColumn(name = "pharmacy_id"),
            inverseJoinColumns = @JoinColumn(name = "dermatologist_id")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Dermatologist> dermatologists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pharmacy")
    private List<Pharmacist> pharmacists;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Warehouse warehouse;

    @OneToOne(fetch = FetchType.LAZY)
    private Pricelist priceList;

    @OneToMany(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "pharmacy_id")
    private List<Shift> shifts;


    public Pharmacy(Long id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(id, pharmacy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
