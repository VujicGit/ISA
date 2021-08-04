package com.isa.user.domain;

import com.isa.supplier.domain.Offer;
import com.isa.supplier.domain.SupplierWarehouse;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier extends User {

    @OneToMany
    private List<Offer> offers;

    @OneToOne
    private SupplierWarehouse warehouse;

    public Supplier() {}
}
