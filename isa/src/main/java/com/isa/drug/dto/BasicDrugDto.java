package com.isa.drug.dto;

import com.isa.drug.domain.Drug;

public class BasicDrugDto {
    
    private Long id;
    private String name;

    public BasicDrugDto() {
    }

    public BasicDrugDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BasicDrugDto(Drug drug) {
        this.id = drug.getId();
        this.name = drug.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
