package com.isa.supplier.domain;

import com.isa.drug.domain.Drug;
import com.isa.supplier.validator.quantity.QuantityValidation;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderedDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @QuantityValidation
    @NotNull(message = "Quantity can not be null")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id")
    private Drug drug;


    public OrderedDrug() {}


    public OrderedDrug(int quantity, Drug drug) {
        this.quantity = quantity;
        this.drug = drug;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

}
