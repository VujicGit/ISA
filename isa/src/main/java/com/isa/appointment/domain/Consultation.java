package com.isa.appointment.domain;

import com.isa.appointment.domain.enums.AppointmentType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = AppointmentType.Values.Consultation)
public class Consultation extends Appointment{

    //TODO Add pharmacist
}
