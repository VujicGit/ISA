package com.isa.pharmacy.dto;

import com.isa.drug.domain.Ingredient;

public class IngredientDto {

    private String name;

    public IngredientDto(String name) {
        this.name = name;
    }

    public IngredientDto() {
    }

    public IngredientDto(Ingredient ingredient) {
        this.name = ingredient.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
