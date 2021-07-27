package com.drug.domain;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private EPrescription ePrescription;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Drug drug;


}
