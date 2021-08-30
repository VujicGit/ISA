package com.isa.supplier.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.supplier.domain.enumeration.OrderStatus;
import com.isa.supplier.validator.dueDate.DueDateValidation;
import com.isa.user.domain.PharmacyAdministrator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Date of creation can not be null")
    private LocalDate creationDate;

    @Column
    @NotNull(message = "Due date can not be null")
    @DueDateValidation
    private LocalDate dueDate;

    @Column
    @NotNull(message = "Order status can not be null")
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "pharmacy_administrator_id")
    private PharmacyAdministrator pharmacyAdministrator;

    @Column(name = "pharmacy_administrator_id", insertable = false, updatable = false)
    private Long pharmacyAdministratorId;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private List<OrderedDrug> orderedDrug;

    @OneToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "order")
    private List<Offer> offers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pharmacy pharmacy;

    public Order() {}

    public Order(LocalDate creationDate, LocalDate dueDate, OrderStatus status, PharmacyAdministrator pharmacyAdministrator, List<OrderedDrug> orderedDrug, List<Offer> offers, Pharmacy pharmacy) {
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
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
