package com.isa.supplier.domain;

import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.user.domain.Pharmacist;
import com.isa.user.domain.PharmacyAdministrator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date creationDate;

    @Column
    private Date dueDate;

    @Column
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    private PharmacyAdministrator pharmacyAdministrator;

    @OneToMany
    private List<OrderedDrug> orderedDrug;

    @OneToMany
    private List<Offer> offers;

    public Order() {}

    public Order(Long id, Date creationDate, Date dueDate, OrderStatus status, PharmacyAdministrator pharmacyAdministrator, List<OrderedDrug> orderedDrug, List<Offer> offers) {
        this.id = id;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.status = status;
        this.pharmacyAdministrator = pharmacyAdministrator;
        this.orderedDrug = orderedDrug;
        this.offers = offers;
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

    public List<OrderedDrug> getOrderedDrug() {
        return orderedDrug;
    }

    public void setOrderedDrug(List<OrderedDrug> orderedDrug) {
        this.orderedDrug = orderedDrug;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
