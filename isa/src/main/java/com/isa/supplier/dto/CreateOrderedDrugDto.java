package com.isa.supplier.dto;

public class CreateOrderedDrugDto {
    private Long drugId;
    private int quantity;

    public CreateOrderedDrugDto(Long drugId, int quantity) {
        this.drugId = drugId;
        this.quantity = quantity;
    }

    public CreateOrderedDrugDto() {
    }

    public Long getDrugId() {
        return drugId;
    }

    public int getQuantity() {
        return quantity;
    }

}
