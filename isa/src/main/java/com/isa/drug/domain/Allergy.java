package com.isa.drug.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Drug drug;


    public Allergy(String name, Drug drug) {
        this.name = name;
        this.drug = drug;
    }

    public Allergy() {

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
