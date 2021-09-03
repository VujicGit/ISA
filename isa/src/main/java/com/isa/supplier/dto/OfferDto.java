package com.isa.supplier.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.supplier.domain.Offer;

import java.time.LocalDateTime;

public class OfferDto {

    private Long id;
    private String supplier;
    private double price;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime date;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dueDate;
    private Long orderId;

    public OfferDto() {
    }

    public OfferDto(String supplier, double price, LocalDateTime date, LocalDateTime dueDate, Long orderId, Long id) {
        this.supplier = supplier;
        this.price = price;
        this.date = date;
        this.dueDate = dueDate;
        this.orderId = orderId;
        this.id = id;
    }

    public OfferDto(Offer offer) {
        this.date = offer.getDate();
        this.dueDate = offer.getDueDate();
        this.orderId = offer.getOrderId();
        this.price = offer.getPrice();
        this.id = offer.getId();
    }

    public String getSupplier() {
        return supplier;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getId() {
        return id;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
