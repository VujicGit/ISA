package com.isa.user.domain;

import com.isa.drug.domain.Allergy;
import com.isa.patient.domain.MedicalRecord;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patient extends User{

    @Column
    private int penalties;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Allergy> allergies;
    //add allergies, eprescriptions

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private MedicalRecord medicalRecord;

    public Patient() {}
}
