package com.isa.supplier.domain;

import com.isa.supplier.domain.enumeration.OfferStatus;
import com.isa.user.domain.Supplier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private OfferStatus status;

    @Column
    @NotNull(message = "Price can not be null")
    private double price;

    @Column
    @NotNull(message = "date can not be null")
    private LocalDateTime date;

    @Column
    @NotNull(message = "date can not be null")
    private LocalDateTime dueDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    private Supplier supplier;

    public Offer() {}

    public Offer(Long id, OfferStatus status, double price, LocalDateTime date, LocalDateTime dueDate, Order order, Supplier supplier, Long orderId) {
        this.id = id;
        this.status = status;
        this.price = price;
        this.date = date;
        this.dueDate = dueDate;
        this.order = order;
        this.supplier = supplier;
        this.orderId = orderId;
    }

    public void acceptOffer(Long offerId, Long pharmacyAdminId) {
        if(getId().equals(offerId)) {
            setStatus(OfferStatus.ACCEPTED);
        }
        else {
            setStatus(OfferStatus.REJECTED);
        }
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
