package com.isa.pharmacy.dto;

import com.isa.pharmacy.domain.Pharmacy;

public class SimplePharmacyDto {
    private Long id;
    private String name;

    public SimplePharmacyDto() {
    }

    public SimplePharmacyDto(Pharmacy pharmacy) {
        this.id = pharmacy.getId();
        this.name = pharmacy.getName();
    }

    public SimplePharmacyDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
