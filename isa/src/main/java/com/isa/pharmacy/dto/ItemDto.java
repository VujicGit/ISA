package com.isa.pharmacy.dto;

import com.isa.pharmacy.domain.Item;

public class ItemDto {

    private String drugName;
    private String drugCode;
    private int quantity;

    public ItemDto() {

    }

    public ItemDto(String drugName, String drugCode, int quantity) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.quantity = quantity;
    }

    public ItemDto(Item item) {
        this.drugName = item.getDrug().getName();
        this.drugCode = item.getDrug().getCode();
        this.quantity = item.getQuantity();
    }

    public String getDrugName() {
        return drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
