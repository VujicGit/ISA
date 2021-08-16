
package com.isa.pharmacy.domain;

import com.isa.drug.domain.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;

    @OneToOne(fetch = FetchType.LAZY)
    private Drug drug;

    public Item(){}

    public Item(Integer quantity, Drug drug) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return drug.equals(item.drug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drug, id, quantity);
    }
}
