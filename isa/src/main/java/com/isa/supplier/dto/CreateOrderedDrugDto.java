package com.isa.supplier.dto;

import com.isa.supplier.validator.quantity.QuantityValidation;

import javax.validation.constraints.NotNull;

public class CreateOrderedDrugDto {
    private Long drugId;

    @QuantityValidation
    @NotNull(message = "Quantity can not be null")
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
