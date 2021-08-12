package com.isa.user.dto;

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
