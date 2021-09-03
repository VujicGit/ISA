package com.isa.user.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.enumeration.Role;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dermatologist extends Employee{

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "dermatologist_pharmacies",
            joinColumns = @JoinColumn(name = "dermatologist_id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacy_id")
    )
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
