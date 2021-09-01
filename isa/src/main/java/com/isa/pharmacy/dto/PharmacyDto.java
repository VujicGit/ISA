package com.isa.pharmacy.dto;

import com.isa.pharmacy.domain.Pharmacy;

public class PharmacyDto {

    private String description;
    private Long id;

    public PharmacyDto() {
    }

    public PharmacyDto(String description, Long id) {
        this.description = description;
        this.id = id;
    }

    public PharmacyDto(Pharmacy pharmacy) {
        this.description = pharmacy.getDescription();
        this.id = pharmacy.getId();
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
