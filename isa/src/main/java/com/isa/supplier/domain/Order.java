package com.isa.supplier.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.user.domain.Pharmacist;
import com.isa.user.domain.PharmacyAdministrator;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @Fetch(FetchMode.JOIN)
    private PharmacyAdministrator pharmacyAdministrator;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @Fetch(FetchMode.JOIN)
    private List<OrderedDrug> orderedDrug;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Offer> offers;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Pharmacy pharmacy;

    public Order() {}

    public Order(Date creationDate, Date dueDate, OrderStatus status, PharmacyAdministrator pharmacyAdministrator, List<OrderedDrug> orderedDrug, List<Offer> offers, Pharmacy pharmacy) {
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.status = status;
        this.pharmacyAdministrator = pharmacyAdministrator;
        this.orderedDrug = orderedDrug;
        this.offers = offers;
        this.pharmacy = pharmacy;
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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
