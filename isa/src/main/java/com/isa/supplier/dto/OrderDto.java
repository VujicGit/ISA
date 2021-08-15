package com.isa.supplier.dto;

import com.isa.supplier.domain.Order;
import com.isa.supplier.domain.enumeration.OrderStatus;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDto {

    private List<OrderedDrugDto> orderedDrugs;
    private String createdBy;
    private LocalDate createdAt;
    private LocalDate dueDate;
    private OrderStatus status;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.createdAt = order.getCreationDate();
        this.createdBy = order.getPharmacyAdministrator().getName() + " " + order.getPharmacyAdministrator().getSurname();
        this.dueDate = order.getDueDate();
        this.status = order.getStatus();
        this.orderedDrugs = order.getOrderedDrug().stream().map(OrderedDrugDto::new).collect(Collectors.toList());
    }

    public OrderDto(List<OrderedDrugDto> orderedDrugs, String createdBy, LocalDate createdAt, LocalDate dueDate, OrderStatus status) {
        this.orderedDrugs = orderedDrugs;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
        this.status = status;
    }

    public List<OrderedDrugDto> getOrderedDrugs() {
        return orderedDrugs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setOrderedDrugs(List<OrderedDrugDto> orderedDrugs) {
        this.orderedDrugs = orderedDrugs;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
