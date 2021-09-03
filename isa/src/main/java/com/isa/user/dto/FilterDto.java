package com.isa.user.dto;

public class FilterDto {

    private String name;
    private String surname;
    private Double minGrade;
    private Double maxGrade;
    private Long pharmacyId;

    public FilterDto(String name, String surname, Double minGrade, Double maxGrade, Long pharmacyId) {
        this.name = name;
        this.surname = surname;
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.pharmacyId = pharmacyId;
    }

    public FilterDto() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Double getMinGrade() {
        return minGrade;
    }

    public Double getMaxGrade() {
        return maxGrade;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMinGrade(Double minGrade) {
        this.minGrade = minGrade;
    }

    public void setMaxGrade(Double maxGrade) {
        this.maxGrade = maxGrade;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
}
