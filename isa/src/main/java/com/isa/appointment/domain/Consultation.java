package com.isa.appointment.domain;

import com.isa.appointment.domain.enums.AppointmentStatus;
import com.isa.appointment.domain.enums.AppointmentType;
import com.isa.patient.domain.Therapy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.user.domain.Patient;
import com.isa.user.domain.Pharmacist;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = AppointmentType.Values.Consultation)
public class Consultation extends Appointment{

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Pharmacist pharmacist;

    public Consultation(Long id, Double cost, AppointmentType type, AppointmentStatus status, Therapy therapy, TimePeriod appointmentPeriod, Patient patient, Pharmacy pharmacy) {
        super(id, cost, type, status, therapy, appointmentPeriod, patient, pharmacy);
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }
}
