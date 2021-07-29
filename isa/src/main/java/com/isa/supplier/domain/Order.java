package com.isa.supplier.domain;

import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.user.domain.Pharmacist;
import com.isa.user.domain.PharmacyAdministrator;

import javax.persistence.*;
import java.util.Date;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date creationDate;
    private Date dueDate;
    private OrderStatus status;
    private PharmacyAdministrator pharmacyAdministrator;
    private OrderedDrug orderedDrug;
    // add offers

    public Order() {}

    public Order(Long id, Date creationDate, Date dueDate, OrderStatus status, PharmacyAdministrator pharmacyAdministrator, OrderedDrug orderedDrug) {
        this.id = id;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.status = status;
        this.pharmacyAdministrator = pharmacyAdministrator;
        this.orderedDrug = orderedDrug;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PharmacyAdministrator getPharmacyAdministrator() {
        return pharmacyAdministrator;
    }

    public void setPharmacyAdministrator(PharmacyAdministrator pharmacyAdministrator) {
        this.pharmacyAdministrator = pharmacyAdministrator;
    }

    public OrderedDrug getOrderedDrug() {
        return orderedDrug;
    }

    public void setOrderedDrug(OrderedDrug orderedDrug) {
        this.orderedDrug = orderedDrug;
    }
}
