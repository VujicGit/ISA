package com.isa.supplier.dto;

import java.util.Date;
import java.util.List;

public class CreateOrderDto {

    private List<CreateOrderedDrugDto> orderedDrugs;
    private Date dueDate;

    public CreateOrderDto() {
    }

    public CreateOrderDto(List<CreateOrderedDrugDto> orderedDrugs, Date dueDate) {
        this.orderedDrugs = orderedDrugs;
        this.dueDate = dueDate;
    }

    public List<CreateOrderedDrugDto> getOrderedDrugs() {
        return orderedDrugs;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setOrderedDrugs(List<CreateOrderedDrugDto> orderedDrugs) {
        this.orderedDrugs = orderedDrugs;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
