package com.isa.user.dto;

import java.util.List;

public class SearchDermatologistDto {
    private String name;
    private String surname;
    private List<String> pharmacies;
    private Double grade;

    public SearchDermatologistDto(String name, String surname, List<String> pharmacies, Double grade) {
        this.name = name;
        this.surname = surname;
        this.pharmacies = pharmacies;
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

    public List<String> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<String> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
