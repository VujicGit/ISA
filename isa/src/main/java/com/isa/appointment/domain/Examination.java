package com.isa.appointment.domain;

import com.isa.appointment.domain.enums.AppointmentType;
import com.isa.user.domain.Dermatologist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = AppointmentType.Values.Examination)
public class Examination extends Appointment{

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "dermatologist_id")
    private Dermatologist dermatologist;

    @Column(name = "dermatologist_id", updatable = false, insertable = false)
    private Long dermatologistId;

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

    public Long getDermatologistId() {
        return dermatologistId;
    }
}
