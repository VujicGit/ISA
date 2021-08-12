package com.isa.user.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Dermatologist extends Employee{

    @ManyToMany(mappedBy = "dermatologists")
    private List<Pharmacy> pharmacies;

    @Column
    private Double grade;

    public Dermatologist() {}

    public Dermatologist(List<Pharmacy> pharmacies, Double grade) {
        this.pharmacies = pharmacies;
        this.grade = grade;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
