package com.isa.user.domain;

import com.isa.drug.domain.Allergy;
import com.isa.patient.domain.MedicalRecord;
import com.isa.user.domain.enumeration.Role;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = Role.Values.PATIENT)
public class Patient extends User{

    @Column
    private int penalties;
    //add allergies, eprescriptions

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private MedicalRecord medicalRecord;

    public Patient() {}
}
