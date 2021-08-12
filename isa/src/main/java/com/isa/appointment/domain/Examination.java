package com.isa.appointment.domain;

import com.isa.appointment.domain.enums.AppointmentStatus;
import com.isa.appointment.domain.enums.AppointmentType;
import com.isa.patient.domain.Therapy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Dermatologist;
import com.isa.user.domain.Patient;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = AppointmentType.Values.Examination)
public class Examination extends Appointment{

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Dermatologist dermatologist;

    public Examination(Long id, Double cost, AppointmentType type, AppointmentStatus status, Therapy therapy, TimePeriod appointmentPeriod, Patient patient, Pharmacy pharmacy) {
        super(id, cost, type, status, therapy, appointmentPeriod, patient, pharmacy);
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }
}
