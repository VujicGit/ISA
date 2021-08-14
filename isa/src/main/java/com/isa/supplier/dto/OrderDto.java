package com.isa.supplier.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {

    private List<OrderedDrugDto> orderedDrugs;
    private String createdBy;
    private Date createdAt;
    private Date dueDate;
    private String status;

    public OrderDto() {
    }

    public OrderDto(List<OrderedDrugDto> orderedDrugs, String createdBy, Date createdAt, Date dueDate, String status) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderedDrugs(List<OrderedDrugDto> orderedDrugs) {
        this.orderedDrugs = orderedDrugs;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
