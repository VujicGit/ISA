package com.isa.appointment.exception;

import com.isa.appointment.domain.Appointment;

public class AppointmentException extends RuntimeException {

    public AppointmentException(String message) {
        super(message);
    }
}
