package com.isa.supplier.dto;

import com.isa.supplier.domain.OrderedDrug;

public class OrderedDrugDto {

    private String name;
    private String code;
    private int quantity;

    public OrderedDrugDto() {
    }

    public OrderedDrugDto(OrderedDrug orderedDrug) {
        this.name = orderedDrug.getDrug().getName();
        this.code = orderedDrug.getDrug().getCode();
        this.quantity = orderedDrug.getQuantity();
    }

    public OrderedDrugDto(String name, String code, int quantity) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
