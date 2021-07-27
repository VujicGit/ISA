package com.drug.domain;

import javax.persistence.*;

@Entity
public class Contraindication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;


}
