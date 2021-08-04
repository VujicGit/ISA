package com.isa.supplier.domain;

import com.isa.supplier.domain.enumeration.OfferStatus;
import com.isa.user.domain.Supplier;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private OfferStatus status;

    @Column
    private double price;

    @Column
    private Date date;

    @Column
    private Date dueDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    private Supplier supplier;

    public Offer() {}

    public Offer(Long id, OfferStatus status, double price, Date date, Date dueDate, Order order, Supplier supplier) {
        this.id = id;
        this.status = status;
        this.price = price;
        this.date = date;
        this.dueDate = dueDate;
        this.order = order;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
