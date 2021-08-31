package com.isa.appointment.domain;

import com.isa.appointment.domain.enums.AppointmentType;
import com.isa.user.domain.Dermatologist;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = AppointmentType.Values.Examination)
public class Examination extends Appointment{

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "dermatologist_id")
    private Dermatologist dermatologist;

    public Examination() {

    }

    public Examination(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }
}
