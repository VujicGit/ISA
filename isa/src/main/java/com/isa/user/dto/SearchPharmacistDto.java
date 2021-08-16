package com.isa.user.dto;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Pharmacist;

public class SearchPharmacistDto {

    private String name;
    private String surname;
    private String pharmacy;
    private Double grade;

    public SearchPharmacistDto(String name, String surname, String pharmacy, Double grade) {
        this.name = name;
        this.surname = surname;
        this.pharmacy = pharmacy;
        this.grade = grade;
    }

    public SearchPharmacistDto(Pharmacist pharmacist) {
        this.name = pharmacist.getName();
        this.surname = pharmacist.getSurname();
        this.pharmacy = pharmacist.getPharmacy().getDescription();
        this.grade = pharmacist.getGrade();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
