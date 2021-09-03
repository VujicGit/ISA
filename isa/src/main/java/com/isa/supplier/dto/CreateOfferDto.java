package com.isa.supplier.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateOfferDto {

    @NotNull(message = "Order id can not be null")
    private Long orderId;
    @NotNull(message = "Price can not be null")
    private double price;
    @NotNull(message = "Due date can not be null")
    private LocalDateTime dueDate;
    @NotNull(message = "Supplier id can not be null")
    private Long supplierId;

    public CreateOfferDto() {
    }

    public CreateOfferDto(Long orderId, double price, LocalDateTime dueDate, Long supplierId) {
        this.orderId = orderId;
        this.price = price;
        this.dueDate = dueDate;
        this.supplierId = supplierId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }


    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
